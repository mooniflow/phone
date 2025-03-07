<template>
    <v-card outlined>
        <v-card-title>
            Timecheck
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="PhoneId" v-model="value.phoneId" :editMode="editMode"/>
            <Date label="ReportDate" v-model="value.reportDate" :editMode="editMode"/>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="timecheck"
            >
                Timecheck
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'TimecheckCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = 0;
            this.value.phoneId = 0;
            this.value.reportDate = '2025-03-07';
            this.value.id = 0;
        },
        watch: {
        },
        methods: {
            timecheck() {
                this.$emit('timecheck', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

