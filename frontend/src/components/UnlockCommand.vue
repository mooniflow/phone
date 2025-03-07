<template>
    <v-card outlined>
        <v-card-title>
            Unlock
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="PhoneId" v-model="value.phoneId" :editMode="editMode"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="Lock" v-model="value.lock" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="unlock"
            >
                Unlock
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
        name: 'UnlockCommand',
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
            this.value.lock = '';
        },
        watch: {
        },
        methods: {
            unlock() {
                this.$emit('unlock', this.value);
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

