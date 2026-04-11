package okhttp3.internal.platform;

import android.content.Context;
import ge.i;
import h5.b;
import java.util.List;
import sd.p;
import uf.e;
import uf.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformInitializer implements b {
    @Override // h5.b
    public final List a() {
        return p.f11669v;
    }

    @Override // h5.b
    public final Object b(Context context) {
        i.e(context, "context");
        f fVar = f.f12506a;
        Object obj = f.f12506a;
        e eVar = obj != null ? (e) obj : null;
        if (eVar != null) {
            eVar.a(context);
        }
        return f.f12506a;
    }
}
