package ga;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5363e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5364g;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = x7.c.f14302a;
        v.j("ApplicationId must be set.", true ^ (str == null || str.trim().isEmpty()));
        this.f5360b = str;
        this.f5359a = str2;
        this.f5361c = str3;
        this.f5362d = str4;
        this.f5363e = str5;
        this.f = str6;
        this.f5364g = str7;
    }

    public static j a(Context context) {
        pb.c cVar = new pb.c(context, 10);
        String strH = cVar.h("google_app_id");
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        return new j(strH, cVar.h("google_api_key"), cVar.h("firebase_database_url"), cVar.h("ga_trackingId"), cVar.h("gcm_defaultSenderId"), cVar.h("google_storage_bucket"), cVar.h("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return v.k(this.f5360b, jVar.f5360b) && v.k(this.f5359a, jVar.f5359a) && v.k(this.f5361c, jVar.f5361c) && v.k(this.f5362d, jVar.f5362d) && v.k(this.f5363e, jVar.f5363e) && v.k(this.f, jVar.f) && v.k(this.f5364g, jVar.f5364g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5360b, this.f5359a, this.f5361c, this.f5362d, this.f5363e, this.f, this.f5364g});
    }

    public final String toString() {
        p2.c cVar = new p2.c(this);
        cVar.b(this.f5360b, "applicationId");
        cVar.b(this.f5359a, "apiKey");
        cVar.b(this.f5361c, "databaseUrl");
        cVar.b(this.f5363e, "gcmSenderId");
        cVar.b(this.f, "storageBucket");
        cVar.b(this.f5364g, "projectId");
        return cVar.toString();
    }
}
