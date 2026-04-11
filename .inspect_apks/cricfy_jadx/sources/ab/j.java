package ab;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import nb.w;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f407e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f408g;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = s8.c.f11618a;
        u.i("ApplicationId must be set.", true ^ (str == null || str.trim().isEmpty()));
        this.f404b = str;
        this.f403a = str2;
        this.f405c = str3;
        this.f406d = str4;
        this.f407e = str5;
        this.f = str6;
        this.f408g = str7;
    }

    public static j a(Context context) {
        w wVar = new w(context);
        String strE = wVar.E("google_app_id");
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        return new j(strE, wVar.E("google_api_key"), wVar.E("firebase_database_url"), wVar.E("ga_trackingId"), wVar.E("gcm_defaultSenderId"), wVar.E("google_storage_bucket"), wVar.E("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return u.j(this.f404b, jVar.f404b) && u.j(this.f403a, jVar.f403a) && u.j(this.f405c, jVar.f405c) && u.j(this.f406d, jVar.f406d) && u.j(this.f407e, jVar.f407e) && u.j(this.f, jVar.f) && u.j(this.f408g, jVar.f408g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f404b, this.f403a, this.f405c, this.f406d, this.f407e, this.f, this.f408g});
    }

    public final String toString() {
        w wVar = new w(this);
        wVar.v(this.f404b, "applicationId");
        wVar.v(this.f403a, "apiKey");
        wVar.v(this.f405c, "databaseUrl");
        wVar.v(this.f407e, "gcmSenderId");
        wVar.v(this.f, "storageBucket");
        wVar.v(this.f408g, "projectId");
        return wVar.toString();
    }
}
