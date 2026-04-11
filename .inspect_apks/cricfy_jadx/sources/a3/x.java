package a3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f242c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f243a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244b = -1;

    public final boolean a(String str) {
        Matcher matcher = f242c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = y1.a0.f14551a;
            int i10 = Integer.parseInt(strGroup, 16);
            int i11 = Integer.parseInt(matcher.group(2), 16);
            if (i10 <= 0 && i11 <= 0) {
                return false;
            }
            this.f243a = i10;
            this.f244b = i11;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(v1.l0 l0Var) {
        int i = 0;
        while (true) {
            v1.k0[] k0VarArr = l0Var.f12828a;
            if (i >= k0VarArr.length) {
                return;
            }
            v1.k0 k0Var = k0VarArr[i];
            if (k0Var instanceof o3.e) {
                o3.e eVar = (o3.e) k0Var;
                if ("iTunSMPB".equals(eVar.f9456c) && a(eVar.f9457d)) {
                    return;
                }
            } else if (k0Var instanceof o3.k) {
                o3.k kVar = (o3.k) k0Var;
                if ("com.apple.iTunes".equals(kVar.f9468b) && "iTunSMPB".equals(kVar.f9469c) && a(kVar.f9470d)) {
                    return;
                }
            } else {
                continue;
            }
            i++;
        }
    }
}
