var app = angular.module('myApp');

app.controller('UserModalCtrl', function(data,$uibModalInstance, UserService, $scope){
	
	var self = this;
	self.data=data;
	console.log(self.data);
	
    self.roles=[];
    self.salesUnits=[];
	
	self.submit = submit;
    self.reset = reset;
	
	UserService.getRoles().then(function(response){
		self.roles = response.data;
	}, function(error){
		alert(error.data);
	});
    
    UserService.getSalesUnits().then(function(response){
		self.salesUnits = response.data;
		console.log('Sales units', self.salesUnits);
	}, function(error){
		alert(error.data);
	});
    
    function submit() {
    	console.log(self.data.id);
        if(self.data.id===null || self.data.id===undefined){
            console.log('Saving New User', self.data);
            createUser(self.data);
        }else{
            updateUser(self.data, self.data.id);
            console.log('User updated with id ', self.data.id);
        }
        reset();
    }
    
    function createUser(user){
        UserService.createUser(user)
            .then(
            		closeModal(user),
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
 
    function updateUser(user, id){
    	console.log(self.data);
        UserService.updateUser(user, id)
            .then(
            		closeModal(user),
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function reset(){
    	console.log('reset');
        self.data={firstName:'', lastName:'', address:'', username:'', password:'', email:''};
        $scope.myForm.$setPristine();
    }
    
    function closeModal(u){
		$uibModalInstance.close(u);
	};
	
});