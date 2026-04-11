package j6;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import c6.i;
import i6.q;
import i6.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f6806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f6807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f6808d;

    public d(Context context, r rVar, r rVar2, Class cls) {
        this.f6805a = context.getApplicationContext();
        this.f6806b = rVar;
        this.f6807c = rVar2;
        this.f6808d = cls;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, i iVar) {
        Uri uri = (Uri) obj;
        return new q(new w6.d(uri), new c(this.f6805a, this.f6806b, this.f6807c, uri, i, i10, iVar, this.f6808d));
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && i5.a.C((Uri) obj);
    }
}
