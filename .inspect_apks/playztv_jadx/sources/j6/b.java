package j6;

import android.content.Context;
import android.net.Uri;
import i6.r;
import i6.s;
import i6.x;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f6798b;

    public b(Context context, Class cls) {
        this.f6797a = context;
        this.f6798b = cls;
    }

    @Override // i6.s
    public final r a(x xVar) {
        Class cls = this.f6798b;
        return new d(this.f6797a, xVar.b(File.class, cls), xVar.b(Uri.class, cls), cls);
    }
}
