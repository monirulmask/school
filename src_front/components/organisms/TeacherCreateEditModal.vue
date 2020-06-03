<template>
  <v-dialog v-model="isActive" persistent max-width="600px">
    <v-card>
      <v-card-title>
        <span class="headline">{{ (updateMode ? 'Edit' : 'Add New') + ' Teacher' }}</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12" sm="6" md="4">
              <v-text-field v-model="localTeacherId" label="ID*" required />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" sm="6" md="4">
              <v-text-field v-model="localTeacherName" label="Name*" required />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" sm="6" md="4">
              <v-text-field v-model="localTeacherAge" label="Age*" required />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" sm="6" md="4">
              <v-text-field
                v-model="localTeacherSalary"
                label="Salary*"
                required
              />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" sm="6">
              <v-radio-group v-model="localTeacherOperationalStatus" row>
                <template v-slot:label>
                  <div>Status</div>
                </template>
                <v-radio label="Active" value="true" />
                <v-radio label="Inactive" value="false" />
              </v-radio-group>
            </v-col>
          </v-row>
        </v-container>
        <small>*indicates required field</small>
      </v-card-text>
      <v-card-actions>
        <v-spacer />
        <v-btn @click="internalCancel" color="blue darken-1" text>
          Close
        </v-btn>
        <v-btn @click="submit" color="blue darken-1" text>
          Save
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'TeacherCreateEditModal',
  props: {
    teacherId: { type: String, required: true },
    teacherName: { type: String, required: true },
    teacherAge: { type: String, required: true },
    teacherSalary: { type: String, required: true },
    teacherOperationalStatus: { type: String, required: true },
    isActive: { type: Boolean, required: true },
    updateMode: { type: Boolean, required: true },
    submit: { type: Function, required: true }
  },
  computed: {
    localTeacherId: {
      get () {
        return this.teacherId
      },
      set (val) {
        this.$emit('update:teacherId', val)
      }
    },
    localTeacherName: {
      get () {
        return this.teacherName
      },
      set (val) {
        this.$emit('update:teacherName', val)
      }
    },
    localTeacherAge: {
      get () {
        return this.teacherAge
      },
      set (val) {
        this.$emit('update:teacherAge', val)
      }
    },
    localTeacherSalary: {
      get () {
        return this.teacherSalary
      },
      set (val) {
        this.$emit('update:teacherSalary', val)
      }
    },
    localTeacherOperationalStatus: {
      get () {
        return this.teacherOperationalStatus
      },
      set (val) {
        this.$emit('update:teacherOperationalStatus', val)
      }
    }
  },
  methods: {
    internalCancel () {
      this.$emit('close')
    }
  }
}
</script>

<style scoped>

</style>
