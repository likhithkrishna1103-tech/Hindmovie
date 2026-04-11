package e7;

import android.content.Context;
import android.net.Uri;
import d7.a0;
import d7.t;
import d7.u;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f3817b;

    public b(Context context, Class cls) {
        this.f3816a = context;
        this.f3817b = cls;
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        Class cls = this.f3817b;
        return new d(this.f3816a, a0Var.b(File.class, cls), a0Var.b(Uri.class, cls), cls);
    }
}
