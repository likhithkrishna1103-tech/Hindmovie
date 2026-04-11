package pc;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements l, r2.m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ String f10325u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f10326v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Serializable f10327w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f10328x;

    public /* synthetic */ f(Object obj, String str, Serializable serializable, Object obj2) {
        this.f10326v = obj;
        this.f10325u = str;
        this.f10327w = serializable;
        this.f10328x = obj2;
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        i iVar = (i) this.f10326v;
        String str2 = (String) this.f10327w;
        HashMap map = (HashMap) this.f10328x;
        if (!z2) {
            iVar.l("http://error", null);
            return;
        }
        String str3 = this.f10325u;
        StringBuilder sbB = v.e.b(str3);
        String string = "https://khhjjshv.com/pro.m3u8";
        if (str3 != null && !str3.isEmpty()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(str3.split("/")));
            while (!arrayList.isEmpty() && ((String) arrayList.get(arrayList.size() - 1)).isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
            }
            if (arrayList.size() >= 2) {
                String str4 = (String) arrayList.get(arrayList.size() - 2);
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                long j5 = 77 + jCurrentTimeMillis;
                String str5 = str4 + str2 + jCurrentTimeMillis + str;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("?token=");
                    byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str5.getBytes(StandardCharsets.ISO_8859_1));
                    StringBuilder sb3 = new StringBuilder();
                    int length = bArrDigest.length;
                    int i = 0;
                    while (i < length) {
                        byte b10 = bArrDigest[i];
                        sb3.append(Character.forDigit((b10 & 255) >> 4, 16));
                        sb3.append(Character.forDigit(b10 & 15, 16));
                        i++;
                        bArrDigest = bArrDigest;
                    }
                    sb2.append(sb3.toString());
                    sb2.append("-");
                    sb2.append(j5);
                    sb2.append("-");
                    sb2.append(jCurrentTimeMillis);
                    string = sb2.toString();
                } catch (Exception unused) {
                }
            }
        }
        sbB.append(string);
        iVar.l(sbB.toString(), map);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    @Override // r2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public aa.c1 g(int r17, p1.g1 r18, int[] r19) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pc.f.g(int, p1.g1, int[]):aa.c1");
    }
}
