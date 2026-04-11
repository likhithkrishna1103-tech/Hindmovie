package rc;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f10987c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10989b;

    public m(Context context, String str) {
        this.f10988a = context;
        this.f10989b = str;
    }

    public final synchronized void a() {
        this.f10988a.deleteFile(this.f10989b);
    }
}
