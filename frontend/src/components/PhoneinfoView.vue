<template>

    <v-data-table
        :headers="headers"
        :items="phoneinfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PhoneinfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "phoneId", value: "phoneId" },
                { text: "reportDate", value: "reportDate" },
                { text: "status", value: "status" },
                { text: "lock", value: "lock" },
                { text: "service", value: "service" },
            ],
            phoneinfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/phoneinfos'))

            temp.data._embedded.phoneinfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.phoneinfo = temp.data._embedded.phoneinfos;
        },
        methods: {
        }
    }
</script>

