package e7;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import d7.s;
import d7.t;
import qb.t1;
import x6.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f3824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f3825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f3826d;

    public d(Context context, t tVar, t tVar2, Class cls) {
        this.f3823a = context.getApplicationContext();
        this.f3824b = tVar;
        this.f3825c = tVar2;
        this.f3826d = cls;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, h hVar) {
        Uri uri = (Uri) obj;
        return new s(new r7.b(uri), new c(this.f3823a, this.f3824b, this.f3825c, uri, i, i10, hVar, this.f3826d));
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && t1.j((Uri) obj);
    }
}
