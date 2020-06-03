<template>
  <v-layout column justify-center align-center>
    <v-card style="width:100%">
      <v-card-title>
        Teacher
      </v-card-title>
      <v-card-subtitle>
        <v-btn
          @click.prevent="openAddTeacherModel"
          class="mt-4"
          depressed
          small
          color="primary"
        >
          新しく追加する
        </v-btn>
      </v-card-subtitle>

      <v-data-table
        :headers="headers"
        :items="gridItemList"
        :items-per-page="-1"
        class="elevation-1"
      >
        <template v-slot:item.teacherOperationalStatus="{ item }">
          <v-icon
            small
            class="mr-2"
          >
            {{ item.teacherOperationalStatus == 'true' ? 'check_circle' : 'cancel' }}
          </v-icon>
        </template>
        <template v-slot:item.action="{ item }">
          <v-icon
            @click="openUpdateTeacherModel(item.teacherId)"
            small
            class="mr-2"
          >
            edit
          </v-icon>
          <v-icon
            @click="removeTeacher(item.teacherId)"
            small
          >
            delete
          </v-icon>
        </template>
      </v-data-table>
      <teacher-create-edit-modal
        v-bind.sync="teacherForm"
        :is-active="showTeacherModel"
        :update-mode="updateMode"
        :submit="saveTeacher"
        @close="cancel"
      />
      <confirm ref="confirm" />
    </v-card>
  </v-layout>
</template>

<script>
import TeacherCreateEditModal from '~/components/organisms/TeacherCreateEditModal'
import Confirm from '~/components/organisms/Confirm.vue'

export default {
  components: {
    TeacherCreateEditModal,
    Confirm
  },
  computed: {
    headers () {
      const headers = [
        { text: 'ID', value: 'teacherId' },
        { text: 'Name', value: 'teacherName' },
        { text: 'Age', value: 'teacherAge' },
        { text: 'Salary', value: 'teacherSalary' },
        { text: 'Status', value: 'teacherOperationalStatus' },
        { text: 'Actions', value: 'action', sortable: false }
      ]
      return headers
    }
  },
  asyncData () {
    return {
      gridItemList: [],
      showTeacherModel: false,
      updateMode: false,
      teacherForm: {
        teacherId: '',
        teacherName: '',
        teacherAge: '',
        teacherSalary: '',
        teacherOperationalStatus: 'true'
      }
    }
  },
  created () {
    this.fetchTeachers()
  },
  methods: {
    fetchTeachers () {
      this.$axios
        .get('/api/teacher')
        .then((response) => {
          this.gridItemList = response.data.teachers
        })
    },
    openAddTeacherModel () {
      this.showTeacherModel = true
      this.updateMode = false
    },
    openUpdateTeacherModel (teacherId) {
      this.updateMode = true
      this.$axios
        .get('/api/teacher/' + teacherId)
        .then((response) => {
          this.teacherForm.teacherId = response.data.teacherId
          this.teacherForm.teacherName = response.data.teacherName
          this.teacherForm.teacherAge = response.data.teacherAge
          this.teacherForm.teacherSalary = response.data.teacherSalary
          this.teacherForm.teacherOperationalStatus = response.data.teacherOperationalStatus
          this.showTeacherModel = true
          this.updateMode = true
        })
    },
    saveTeacher () {
      if (this.updateMode) {
        return this.$axios
          .put('/api/teacher/' + this.teacherForm.teacherId, {
            teacherId: this.teacherForm.teacherId,
            teacherName: this.teacherForm.teacherName,
            teacherAge: this.teacherForm.teacherAge,
            teacherSalary: this.teacherForm.teacherSalary,
            teacherOperationalStatus: this.teacherForm.teacherOperationalStatus
          })
          .then(() => {
            this.$bus.$emit('snackbar:success', 'Teacher Updated successfully.')
            this.cancel()
          })
      } else {
        return this.$axios
          .post('/api/teacher', {
            teacherId: this.teacherForm.teacherId,
            teacherName: this.teacherForm.teacherName,
            teacherAge: this.teacherForm.teacherAge,
            teacherSalary: this.teacherForm.teacherSalary,
            teacherOperationalStatus: this.teacherForm.teacherOperationalStatus
          })
          .then(() => {
            this.$bus.$emit('snackbar:success', 'New teacher added successfully.')
            this.cancel()
          })
      }
    },
    removeTeacher (teacherId) {
      this.$refs.confirm.open('Delete', 'Are you sure?', { color: 'red' }).then((confirm) => {
        if (confirm) {
          return this.$axios
            .delete('/api/teacher/' + teacherId)
            .then(() => {
              this.fetchTeachers()
              this.$bus.$emit('snackbar:success', 'Successfully Deleted.')
            })
        }
      })
    },
    cancel () {
      this.showTeacherModel = false
      this.resetForm()
      this.fetchTeachers()
    },
    resetForm () {
      this.teacherForm = {
        teacherId: '',
        teacherName: '',
        teacherAge: '',
        teacherSalary: '',
        teacherOperationalStatus: 'true'
      }
    }
  }
}
</script>
<style scoped>
.transparent {
  background-color: white !important;
  opacity: 0.8;
  border-color: transparent !important;
}
</style>
