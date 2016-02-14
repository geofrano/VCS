package PPA_EXT_PAS.dominio;

/**
 * Creado: CLS Juan Torres
 * Proyecto: 9553: Workflow Bodega Multicompa�ia.
 * Fecha: 12/06/2014
 * LIDER CLS: Mariuxi Dominguez
 */

public class GBB_SolRetiroDetalle_ret_new {

	public  GBB_SolRetiroDetalle_ret_new(){}
	   
	   private String ID_STUD_RETIRO_DET="";//se lo obtiene de la base de datos
	   private String ID_STUD_RETIRO="";

	   private String ENSTOCK;//el valor del check de la primera columna
	   
	   private String ARTICULO="";//
	   private String DESCRIPCION="";//
	   private int CANTIDAD;//
	   private String SERIE="";//
	   private String DESTINO="";//
	   private String DESTINOSELECT="S";//S=selecciona del combobox - N=ingresa forma manual
	   private String LOTE="";
	   private String CHECK="";
	   private String DUI ="";
	   private String ORDEN="";
	   private String PACK="";
	      
	   private String storage_area="";
	   private String nivel_1="";
	   private String nivel_2="";
	   private String nivel_3="";
	   private String nivel_4="";
	   private String container_id="";
	   //9553
	   private String CONTRATISTA="";
	   //9533
	   
	   //9019
	   private String estadoArticulo;
	   private String estado;
	   private String usuario;
	   private String FechaSolicitud;

	                   
	   public String getstorage_area(){     
			return storage_area;     
		 }     
		 public void setstorage_area(String value){     
			this.storage_area=value;     
		 }
		 
		 public String getnivel_1(){     
			return nivel_1;     
		 }     
		 public void setnivel_1(String value){     
			this.nivel_1=value;     
		 }
	   
	    public String getnivel_2(){     
			return nivel_2;     
		 }     
		 public void setnivel_2(String value){     
			this.nivel_2=value;     
		 }
		  public String getnivel_3(){     
			return nivel_3;     
		 }     
		 public void setnivel_3(String value){     
			this.nivel_3=value;     
		 }
		 
		 public String getnivel_4(){     
			return nivel_4;     
		 }     
		 public void setnivel_4(String value){     
			this.nivel_4=value;     
		 }
	   
	   public String getcontainer_id(){     
			return container_id;     
		 }     
		 public void setcontainer_id(String value){     
			this.container_id=value;     
		 }

		   public String getestado(){     
				return estado;     
			 }     
			 public void setestado(String value){     
				if (value.equals("Dañado"))
				{
					this.estado="Da�ado";	     
				}else if (value.equals("Garantía"))
				{
					this.estado="Garant�a";	     
				}else
				{
					this.estado=value;
				}
											
			 }
		 
	    public String getDUI(){     
			return DUI;     
		 }     
		 public void setDUI(String value){     
			this.DUI=value;     
		 }
		  public String getORDEN(){     
			return ORDEN;     
		 }     
		 public void setORDEN(String value){     
			this.ORDEN=value;     
		 }
		  public String getPACK(){     
			return PACK;     
		 }     
		 public void setPACK(String value){     
			this.PACK=value;     
		 }
	    public String getLOTE(){     
			return LOTE;     
		 }     
		 public void setLOTE(String value){     
			this.LOTE=value;     
		 }
	   
	   public String getCHECK(){     
			return CHECK;     
		 }     
		 public void setCHECK(String value){     
			this.CHECK=value;     
		 }
	   
	   
	   public String getDESCRIPCION(){     
			return DESCRIPCION;     
		}     
		public void setDESCRIPCION(String value){     
			this.DESCRIPCION=value;     
		}
	   
	   public String getDESTINOSELECT(){     
			return DESTINOSELECT;     
		}     
		public void setDESTINOSELECT(String value){     
			this.DESTINOSELECT=value;     
		}
	   
	   
	    public String getID_STUD_RETIRO(){     
			return ID_STUD_RETIRO;     
		}     
		public void setID_STUD_RETIRO(String value){     
			this.ID_STUD_RETIRO=value;     
		}
		
		 public String getID_STUD_RETIRO_DET(){     
			return ID_STUD_RETIRO_DET;     
		 }     
		 public void setID_STUD_RETIRO_DET(String value){     
			this.ID_STUD_RETIRO_DET=value;     
		 }
		 
		 public String getARTICULO(){     
			return ARTICULO;     
		 }     
		 public void setARTICULO(String value){     
			this.ARTICULO=value;     
		 }
		
		 public int getCANTIDAD(){     
			return CANTIDAD;     
		 }     
		 public void setCANTIDAD(int value){     
			this.CANTIDAD=value;     
		 }

		 public String getSERIE(){     
			return SERIE;     
		 }     
		 public void setSERIE(String value){     
			this.SERIE=value;     
		 }	
		 
		 public String getDESTINO(){     
			return DESTINO;     
		 }     
		 public void setDESTINO(String value){     
			this.DESTINO=value;     
		 }
		 
		 public String getENSTOCK(){     
			return ENSTOCK;     
		 }     
		 public void setENSTOCK(String value){     
			this.ENSTOCK=value;     
		 }
		public String getEstadoArticulo() {
			return estadoArticulo;
		}
		public void setEstadoArticulo(String estadoArticulo) {
			this.estadoArticulo = estadoArticulo;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getFechaSolicitud() {
			return FechaSolicitud;
		}
		public void setFechaSolicitud(String fechaSolicitud) {
			FechaSolicitud = fechaSolicitud;
		}	
		 
		//9553
	    public String getCONTRATISTA(){     
			return CONTRATISTA;     
		 }     
		 public void setCONTRATISTA(String value){     
			this.CONTRATISTA=value;     
		 }
		
}

