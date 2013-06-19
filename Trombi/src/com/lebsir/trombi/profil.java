package com.lebsir.trombi;





	public class profil {
		
		private int id;
		private String nom;
		private String prenom;
		private String image;
		
		public profil(){
		}
		
		public profil(int id, String nom, String prenom, String image){
			this.id=id;
			this.nom=nom;
			this.prenom=prenom;
			this.image=image;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getNom() {
			return nom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getImage() {
			return image;
		}



}
