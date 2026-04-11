package androidx.fragment.app;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements v5.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ x5.r f1076v;

    public /* synthetic */ u(x5.r rVar) {
        this.f1076v = rVar;
    }

    @Override // v5.b
    public void a(String str, String str2, String str3, String str4) {
        y5.i iVar = new y5.i(str, str2, str3, str4, !TextUtils.isEmpty(str3));
        x5.r rVar = this.f1076v;
        rVar.f14377u0.add(iVar);
        s5.p pVar = rVar.f14376t0;
        ((ArrayList) pVar.f11522g).add(iVar);
        pVar.f13407a.d(((ArrayList) pVar.f11522g).size());
    }
}
