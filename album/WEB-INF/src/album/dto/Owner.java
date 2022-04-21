package album.dto;

/**
 * オーナー情報
 */
public class Owner {
    /**
     * オーナーID（ログインID）
     */
    private String ownerid;

    /**
     * ログインパスワード
     */
    private String password;

    /**
     * オーナー名
     */
    private String ownername;

    /**
     * プロフィール
     */
    private String ownerprofile;

    /**
     * オーナー画像のパス
     */
    private String ownerimagepath;

    /**
     * 電話番号
     */
    private String ownertelno;

    /**
     * メールアドレス
     */
    private String ownermail;

    /**
     * Twitter
     */
    private String ownertwitter;

    /**
     * Instagram
     */
    private String ownerinstagram;

    /**
     * facebook
     */
    private String ownerfacebook;

    public Owner() {
        this.ownerid = "";
        this.password = "";
        this.ownername = "";
        this.ownerprofile = "";
        this.ownerimagepath = "";
        this.setOwnertelno("");
        this.setOwnermail("");
        this.setOwnertwitter("");
        this.setOwnerinstagram("");
        this.setOwnerfacebook("");
    }

    /**
     * Getter for ownerid
     * @return ownerid
     */
    public String getOwnerid() {
        return this.ownerid;
    }

    /**
     * Getter for password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter for ownername
     * @return ownername
     */
    public String getOwnername() {
        return this.ownername;
    }

    /**
     * Getter for ownerprofile
     * @return ownerprofile
     */
    public String getOwnerprofile() {
        return this.ownerprofile;
    }

    /**
     * Getter for ownerimagepath
     * @return ownerimagepath
     */
    public String getOwnerimagepath() {
        return this.ownerimagepath;
    }

    /**
     * @return the ownertelno
     */
    public String getOwnertelno() {
        return ownertelno;
    }

    /**
     * @return the ownermail
     */
    public String getOwnermail() {
        return ownermail;
    }

    /**
     * @return the ownertwitter
     */
    public String getOwnertwitter() {
        return ownertwitter;
    }

    /**
     * @return the ownerinstagram
     */
    public String getOwnerinstagram() {
        return ownerinstagram;
    }

    /**
     * @return the ownerfacebook
     */
    public String getOwnerfacebook() {
        return ownerfacebook;
    }

    /**
     * Setter for ownerid
     * @param ownerid
     */
    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * Setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter for ownername
     * @param ownername
     */
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    /**
     * Setter for ownerprofile
     * @param ownerprofile
     */
    public void setOwnerprofile(String ownerprofile) {
        this.ownerprofile = ownerprofile;
    }

    /**
     * Setter for ownerimagepath
     * @param ownerimagepath
     */
    public void setOwnerimagepath(String ownerimagepath) {
        this.ownerimagepath = ownerimagepath;
    }

    /**
     * @param ownertelno the ownertelno to set
     */
    public void setOwnertelno(String ownertelno) {
        this.ownertelno = ownertelno;
    }

    /**
     * @param ownermail the ownermail to set
     */
    public void setOwnermail(String ownermail) {
        this.ownermail = ownermail;
    }

    /**
     * @param ownertwitter the ownertwitter to set
     */
    public void setOwnertwitter(String ownertwitter) {
        this.ownertwitter = ownertwitter;
    }

    /**
     * @param ownerinstagram the ownerinstagram to set
     */
    public void setOwnerinstagram(String ownerinstagram) {
        this.ownerinstagram = ownerinstagram;
    }

    /**
     * @param ownerfacebook the ownerfacebook to set
     */
    public void setOwnerfacebook(String ownerfacebook) {
        this.ownerfacebook = ownerfacebook;
    }

    /**
     * Ownerが有効かどうかチェック<br>
     * ownernameが空なら無効なユーザー
     * @return boolean
     */
    public boolean isValidOwner() {
        return !this.ownername.isEmpty();
    }
}
