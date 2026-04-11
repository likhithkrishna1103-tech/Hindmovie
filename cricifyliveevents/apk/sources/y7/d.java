package y7;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.b f14970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7.a f14971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f14972c;

    public d(Context context, l7.a aVar) {
        vb.b bVar = new vb.b(context);
        this.f14972c = new HashMap();
        this.f14970a = bVar;
        this.f14971b = aVar;
    }

    public final synchronized e a(String str) {
        if (this.f14972c.containsKey(str)) {
            return (e) this.f14972c.get(str);
        }
        CctBackendFactory cctBackendFactoryE = this.f14970a.e(str);
        if (cctBackendFactoryE == null) {
            return null;
        }
        l7.a aVar = this.f14971b;
        e eVarCreate = cctBackendFactoryE.create(new b((Context) aVar.f7866w, (g8.a) aVar.f7867x, (g8.a) aVar.f7868y, str));
        this.f14972c.put(str, eVarCreate);
        return eVarCreate;
    }
}
