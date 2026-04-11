package d7;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.gms.internal.measurement.k4;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k4 f4095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.b f4096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4097c;

    public d(Context context, a7.b bVar) {
        k4 k4Var = new k4(context);
        this.f4097c = new HashMap();
        this.f4095a = k4Var;
        this.f4096b = bVar;
    }

    public final synchronized e a(String str) {
        if (this.f4097c.containsKey(str)) {
            return (e) this.f4097c.get(str);
        }
        CctBackendFactory cctBackendFactoryU = this.f4095a.u(str);
        if (cctBackendFactoryU == null) {
            return null;
        }
        a7.b bVar = this.f4096b;
        e eVarCreate = cctBackendFactoryU.create(new b((Context) bVar.f618v, (l7.a) bVar.f619w, (l7.a) bVar.f620x, str));
        this.f4097c.put(str, eVarCreate);
        return eVarCreate;
    }
}
