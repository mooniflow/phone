<template>
    <v-card outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            Phonemanagement # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            Phonemanagement
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <Number label="PhoneId" v-model="value.phoneId" :editMode="editMode" :inputUI="''"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode" :inputUI="''"/>
            <String label="Status" v-model="value.status" :editMode="editMode" :inputUI="''"/>
            <String label="Lock" v-model="value.lock" :editMode="editMode" :inputUI="''"/>
            <String label="Service" v-model="value.service" :editMode="editMode" :inputUI="''"/>
        </v-card-text>

        <v-card-actions style="background-color: white;">
            <v-spacer></v-spacer>
            <div v-if="!editMode">
                <v-btn
                    color="primary"
                    text
                    @click="edit"
                >
                    수정
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                >
                    삭제
                </v-btn>
            </div>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                저장
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openLock"
            >
                Lock
            </v-btn>
            <v-dialog v-model="lockDiagram" width="500">
                <LockCommand
                    @closeDialog="closeLock"
                    @lock="lock"
                ></LockCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openStoptheservice"
            >
                Stoptheservice
            </v-btn>
            <v-dialog v-model="stoptheserviceDiagram" width="500">
                <StoptheserviceCommand
                    @closeDialog="closeStoptheservice"
                    @stoptheservice="stoptheservice"
                ></StoptheserviceCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openUnlock"
            >
                Unlock
            </v-btn>
            <v-dialog v-model="unlockDiagram" width="500">
                <UnlockCommand
                    @closeDialog="closeUnlock"
                    @unlock="unlock"
                ></UnlockCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openStarttheservice"
            >
                Starttheservice
            </v-btn>
            <v-dialog v-model="starttheserviceDiagram" width="500">
                <StarttheserviceCommand
                    @closeDialog="closeStarttheservice"
                    @starttheservice="starttheservice"
                ></StarttheserviceCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'PhonemanagementPhonemanagement',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
            },
            lockDiagram: false,
            stoptheserviceDiagram: false,
            unlockDiagram: false,
            starttheserviceDiagram: false,
        }),
	async created() {
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/phonemanagements'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async lock() {
                try {
                    if(!this.offline){
                        var temp = await axios.post(axios.fixUrl(this.value._links['/lock'].href))
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    }

                    this.editMode = false;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            async stoptheservice() {
                try {
                    if(!this.offline){
                        var temp = await axios.post(axios.fixUrl(this.value._links['/stoptheservice'].href))
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    }

                    this.editMode = false;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            async unlock() {
                try {
                    if(!this.offline){
                        var temp = await axios.post(axios.fixUrl(this.value._links['/unlock'].href))
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    }

                    this.editMode = false;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            async starttheservice() {
                try {
                    if(!this.offline){
                        var temp = await axios.post(axios.fixUrl(this.value._links['/starttheservice'].href))
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    }

                    this.editMode = false;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
        },
    }
</script>

