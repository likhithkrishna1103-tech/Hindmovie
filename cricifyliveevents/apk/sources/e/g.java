package e;

import androidx.media3.decoder.DecoderInputBuffer;
import c.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t1 f3746d;

    public /* synthetic */ g(l lVar, String str, t1 t1Var, int i) {
        this.f3743a = i;
        this.f3744b = lVar;
        this.f3745c = str;
        this.f3746d = t1Var;
    }

    @Override // e.c
    public final void a(Object obj) {
        switch (this.f3743a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l lVar = this.f3744b;
                ArrayList arrayList = lVar.f1971d;
                LinkedHashMap linkedHashMap = lVar.f1969b;
                String str = this.f3745c;
                Object obj2 = linkedHashMap.get(str);
                t1 t1Var = this.f3746d;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + t1Var + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                arrayList.add(str);
                try {
                    lVar.b(iIntValue, t1Var, obj);
                    return;
                } catch (Exception e9) {
                    arrayList.remove(str);
                    throw e9;
                }
            default:
                l lVar2 = this.f3744b;
                ArrayList arrayList2 = lVar2.f1971d;
                LinkedHashMap linkedHashMap2 = lVar2.f1969b;
                String str2 = this.f3745c;
                Object obj3 = linkedHashMap2.get(str2);
                t1 t1Var2 = this.f3746d;
                if (obj3 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + t1Var2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj3).intValue();
                arrayList2.add(str2);
                try {
                    lVar2.b(iIntValue2, t1Var2, obj);
                    return;
                } catch (Exception e10) {
                    arrayList2.remove(str2);
                    throw e10;
                }
        }
    }

    public void b() {
        this.f3744b.f(this.f3745c);
    }
}
