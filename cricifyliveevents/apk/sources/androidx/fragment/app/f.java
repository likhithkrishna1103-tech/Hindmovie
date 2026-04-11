package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements p0.b, v2.l, z5.k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f980v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f981w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f982x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f983y;

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f980v = obj;
        this.f981w = obj2;
        this.f982x = obj3;
        this.f983y = obj4;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    @Override // v2.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ua.z0 b(int r17, v1.g1 r18, int[] r19) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.f.b(int, v1.g1, int[]):ua.z0");
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        z5.i iVar = (z5.i) this.f980v;
        String str2 = (String) this.f981w;
        String str3 = (String) this.f982x;
        HashMap map = (HashMap) this.f983y;
        if (!z10) {
            iVar.j("http://error", null);
            return;
        }
        StringBuilder sbB = y.e.b(str2);
        String string = "https://khhjjshv.com/pro.m3u8";
        if (str2 != null && !str2.isEmpty()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(str2.split("/")));
            while (!arrayList.isEmpty() && ((String) arrayList.get(arrayList.size() - 1)).isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
            }
            if (arrayList.size() >= 2) {
                String str4 = (String) arrayList.get(arrayList.size() - 2);
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                long j4 = 77 + jCurrentTimeMillis;
                String str5 = str4 + str3 + jCurrentTimeMillis + str;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("?token=");
                    byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str5.getBytes(StandardCharsets.ISO_8859_1));
                    StringBuilder sb2 = new StringBuilder();
                    int length = bArrDigest.length;
                    int i = 0;
                    while (i < length) {
                        byte b8 = bArrDigest[i];
                        sb2.append(Character.forDigit((b8 & 255) >> 4, 16));
                        sb2.append(Character.forDigit(b8 & 15, 16));
                        i++;
                        bArrDigest = bArrDigest;
                    }
                    sb.append(sb2.toString());
                    sb.append("-");
                    sb.append(j4);
                    sb.append("-");
                    sb.append(jCurrentTimeMillis);
                    string = sb.toString();
                } catch (Exception unused) {
                }
            }
        }
        sbB.append(string);
        iVar.j(sbB.toString(), map);
    }

    @Override // p0.b
    public void onCancel() {
        View view = (View) this.f980v;
        l lVar = (l) this.f981w;
        g gVar = (g) this.f982x;
        e1 e1Var = (e1) this.f983y;
        ge.i.e(lVar, "this$0");
        ge.i.e(gVar, "$animationInfo");
        ge.i.e(e1Var, "$operation");
        view.clearAnimation();
        lVar.f1014a.endViewTransition(view);
        gVar.d();
        if (r0.J(2)) {
            Log.v("FragmentManager", "Animation from operation " + e1Var + " has been cancelled.");
        }
    }
}
