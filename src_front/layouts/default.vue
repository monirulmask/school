<template>
  <div class="back">
    <v-app id="inspire">
      <v-app-bar app dark>
        <v-app-bar-nav-icon>
          <v-avatar>
            <img src="~/assets/luffy.png" alt="avatar">
          </v-avatar>
        </v-app-bar-nav-icon>
        <v-toolbar-title>School</v-toolbar-title>
      </v-app-bar>
      <v-content>
        <v-container fluid>
          <nuxt />
        </v-container>
      </v-content>
      <v-footer fixed app>
        <span>&copy; 2019</span>
      </v-footer>
      <Snackbars />
    </v-app>
  </div>
</template>

<script>
import Snackbars from '~/components/organisms/Snackbars.vue'
export default {
  components: {
    Snackbars
  },
  data () {
    return {
      right: true,
      rightDrawer: false,
      title: 'School'
    }
  }
}
</script>
