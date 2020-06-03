<template>
  <v-snackbar
    v-model="isEnabled"
    :color="color"
    :multi-line="true"
    :timeout="timeout"
    top
  >
    {{ text }}
    <v-btn
      @click="isEnabled = false"
      dark
      text
    >
      <v-icon>
        close
      </v-icon>
    </v-btn>
  </v-snackbar>
</template>

<script>
export default {
  data () {
    return {
      isEnabled: false,
      text: '',
      color: 'success',
      timeout: 5000
    }
  },
  created () {
    this.$bus.$on('snackbar:success', (text) => {
      this.isEnabled = !!text
      this.text = text
    })
    this.$bus.$on('snackbar:error', (text) => {
      this.isEnabled = !!text
      this.text = text
      this.color = 'error'
      this.timeout = 0
    })
  }
}
</script>
