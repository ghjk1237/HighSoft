package sys.Eval.page.Model;
/***********************************************************************
 * Module:  BiCorporation.java
 * Author:  yxc23
 * Purpose: Defines the Class BiCorporation
 ***********************************************************************/

import java.util.*;

/** 机构编码（集团下所属机构）
 * 
 * @pdOid 3b5a497c-a698-41c7-b436-904e4b44d05b */
public class BiCorporation {
   /** 机构代码
    * 
    * @pdOid 41797513-6f2b-415e-b0ee-e714406f6fce */
   private java.lang.String corpId;
   /** 机构名称
    * 
    * @pdOid 817a78c1-4f32-4337-a8ca-a7c6583d6970 */
   private java.lang.String corpName;
   /** 医疗机构名称
    * 
    * @pdOid ff34a154-d119-4f13-ae38-2ac2445041da */
   private java.lang.String hospId;
   /** 医疗机构编码
    * 
    * @pdOid d97c532d-cfd1-4b1c-9565-13c93a6076fc */
   private java.lang.String hospName;
   /** 是否有效
    * 
    * @pdOid a9c994d1-4332-4c58-b6d2-ec51973f0479 */
   private boolean isValid;
   
   /** 备注
    * 
    * @pdOid 01e9609f-e317-4f59-b3b4-182db152637e */
   public java.lang.String memo;
   
   /** @pdRoleInfo migr=no name=BiDepartment assc=ksJg coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<BiDepartment> biDepartment;
   
   /** @pdOid eb080556-bdef-4169-b9c9-8f8fc5cc2389 */
   public java.lang.String getCorpId() {
	  
      return corpId;
   }
   
   /** @param newCorpId
    * @pdOid d94f4350-9f5e-4131-8860-a4dd2ed87dda */
   public void setCorpId(java.lang.String newCorpId) {
      corpId = newCorpId;
   }
   
   /** @pdOid 56c39e67-e1fc-467f-b2ef-72c0aa961097 */
   public java.lang.String getCorpName() {
      return corpName;
   }
   
   /** @param newCorpName
    * @pdOid ce4ba43b-a357-4ea5-b293-d9da7fcfd6c7 */
   public void setCorpName(java.lang.String newCorpName) {
      corpName = newCorpName;
   }
   
   /** @pdOid caaf06ac-bdf6-474a-b5a6-f9174278ac4b */
   public java.lang.String getHospId() {
      return hospId;
   }
   
   /** @param newHospId
    * @pdOid 3492ec69-c0ad-43ba-94ab-29eff9a15378 */
   public void setHospId(java.lang.String newHospId) {
      hospId = newHospId;
   }
   
   /** @pdOid 910457a8-8a80-4a34-9fca-269f5bb0723f */
   public java.lang.String getHospName() {
      return hospName;
   }
   
   /** @param newHospName
    * @pdOid fc4f73db-5028-4ac2-904d-0ed037d04c41 */
   public void setHospName(java.lang.String newHospName) {
      hospName = newHospName;
   }
   
   /** @pdOid 8a6a9346-91ac-4eb2-8d0e-5854f0ebbeb0 */
   public boolean getIsValid() {
      return isValid;
   }
   
   /** @param newIsValid
    * @pdOid 5e8bf5a0-baf7-4b6e-b327-f8136891bc3e */
   public void setIsValid(boolean newIsValid) {
      isValid = newIsValid;
   }
   
   /** @pdOid b43154b2-c805-4be8-aea2-4e0de6fc8c34 */
   public java.lang.String getMemo() {
      return memo;
   }
   
   /** @param newMemo
    * @pdOid 46bc621c-d00d-4609-80be-e75d5ce46093 */
   public void setMemo(java.lang.String newMemo) {
      memo = newMemo;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<BiDepartment> getBiDepartment() {
      if (biDepartment == null)
         biDepartment = new java.util.HashSet<BiDepartment>();
      return biDepartment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBiDepartment() {
      if (biDepartment == null)
         biDepartment = new java.util.HashSet<BiDepartment>();
      return biDepartment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBiDepartment */
   public void setBiDepartment(java.util.Collection<BiDepartment> newBiDepartment) {
      removeAllBiDepartment();
      for (java.util.Iterator iter = newBiDepartment.iterator(); iter.hasNext();)
         addBiDepartment((BiDepartment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBiDepartment */
   public void addBiDepartment(BiDepartment newBiDepartment) {
      if (newBiDepartment == null)
         return;
      if (this.biDepartment == null)
         this.biDepartment = new java.util.HashSet<BiDepartment>();
      if (!this.biDepartment.contains(newBiDepartment))
      {
         this.biDepartment.add(newBiDepartment);
         newBiDepartment.setBiCorporation(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldBiDepartment */
   public void removeBiDepartment(BiDepartment oldBiDepartment) {
      if (oldBiDepartment == null)
         return;
      if (this.biDepartment != null)
         if (this.biDepartment.contains(oldBiDepartment))
         {
            this.biDepartment.remove(oldBiDepartment);
            oldBiDepartment.setBiCorporation((BiCorporation)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBiDepartment() {
      if (biDepartment != null)
      {
         BiDepartment oldBiDepartment;
         for (java.util.Iterator iter = getIteratorBiDepartment(); iter.hasNext();)
         {
            oldBiDepartment = (BiDepartment)iter.next();
            iter.remove();
            oldBiDepartment.setBiCorporation((BiCorporation)null);
         }
      }
   }

}