const {createApp} = Vue;

createApp({
	data() {
		return {
			nickName:'',
			contraseña: '',
			nombre:'',
            apellido : '',
			telefono: '',
            nickNameRegistro :'',
            correoRegistro:'',
            contraseñaRegistro:'',
			
		};
	},
	created() {
		this.data();
	},
	methods: {
		
		data() {
			axios
				.get('/api/clientes/actual')
				.then(response => {
                    this.datos = response.data;
                    console.log(this.datos)
				})
				.catch(error => console.log(error));
		},
		ingresar() {
			axios
				.post('/api/login', 'nickName=' + this.nickName + '&contraseña=' + this.contraseña)
				.then(response => {
					Swal.fire({
						icon: 'success',
						text: 'Ingreso Exitoso',
						showConfirmButton: false,
						timer: 2000,
					}).then(() => {
						if (this.correo == 'admin@admin.com') {
							window.location.replace('/index.html');
						} else {
							window.location.replace('/index.html');
						}
					});
				})
				.catch(error =>
					Swal.fire({
						icon: 'error',
						text: "El nickname o la contraseña son incorrectas",
						confirmButtonColor: '#7c601893',
					})
				);
		},
		register() {
			axios
				.post(
					'/api/clientes',
					'nombre=' +
						this.nombre +
						'&apellido=' +
						this.apellido +
                        '&nickName=' +
                        this.nickNameRegistro+
                        '&correo=' +
						this.correoRegistro +
						'&telefono=' +
						this.telefono +
						'&contraseña=' +
						this.contraseñaRegistro
				)
				.then(response => {
					Swal.fire({
						icon: 'success',
						text: 'Se registro exitosamente',
						showConfirmButton: false,
						timer: 2000,
					}).then(() => {
						this.correo = this.correoRegistro;
						this.contraseña = this.contraseñaRegistro;
						window.location.replace('/index.html');
					});
				})
				.catch(error =>
					Swal.fire({
						icon: 'error',
						text: error.response.data,
					})
				);
		},
        salir() {
			Swal.fire({
				title: '¿Estas seguro que quieres salir de tu cuenta?',
				inputAttributes: {
					autocapitalize: 'off',
				},
				showCancelButton: true,
				confirmButtonText: 'Sure',
				showLoaderOnConfirm: true,
				preConfirm: login => {
					return axios
						.post('/api/logout')
						.then(response => {
							this.carrito = []
							window.location.href = '/index.html';
						})
						.catch(error =>
							Swal.fire({
								icon: 'error',
								text: error.response.data,
							})
						);
				},
				allowOutsideClick: () => !Swal.isLoading(),
			});
		},
		
	},
}).mount('#app');

/* Contraseña */
const pwShowHide = document.querySelectorAll('.pw-hide');
pwShowHide.forEach(icon => {
	icon.addEventListener('click', () => {
		let getPwInput = icon.parentElement.querySelector('input');
		if (getPwInput.type === 'password') {
			getPwInput.type = 'text';
			icon.classList.replace('fa-eye-slash', 'fa-eye');
		} else {
			getPwInput.type = 'password';
			icon.classList.replace('fa-eye', 'fa-eye-slash');
		}
	});
});

