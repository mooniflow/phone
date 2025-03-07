<template>
    <v-card outlined>
        <v-card-title>
            CancelReport
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="PhoneId" v-model="value.phoneId" :editMode="editMode"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Date label="ReportDate" v-model="value.reportDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="cancelReport"
            >
                CancelReport
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
        name: 'CancelReportCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.phoneId = 0;
            this.value.userId = 0;
            this.value.reportDate = '2025-03-07';
        },
        watch: {
        },
        methods: {
            cancelReport() {
                this.$emit('cancelReport', this.value);
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

