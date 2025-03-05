<template>

    <v-card outlined>
        <v-card-title>
            Phoneinfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PhoneId" v-model="item.phoneId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReportDate" v-model="item.reportDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Lock" v-model="item.lock" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Service" v-model="item.service" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PhoneinfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/phoneinfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

