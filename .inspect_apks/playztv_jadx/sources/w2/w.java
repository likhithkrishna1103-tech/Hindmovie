package w2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.k0;
import p1.l0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f13679c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13680a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13681b = -1;

    public final boolean a(String str) {
        Matcher matcher = f13679c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = s1.b0.f11647a;
            int i10 = Integer.parseInt(strGroup, 16);
            int i11 = Integer.parseInt(matcher.group(2), 16);
            if (i10 <= 0 && i11 <= 0) {
                return false;
            }
            this.f13680a = i10;
            this.f13681b = i11;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(l0 l0Var) {
        int i = 0;
        while (true) {
            k0[] k0VarArr = l0Var.f9896a;
            if (i >= k0VarArr.length) {
                return;
            }
            k0 k0Var = k0VarArr[i];
            if (k0Var instanceof k3.e) {
                k3.e eVar = (k3.e) k0Var;
                if ("iTunSMPB".equals(eVar.f6990c) && a(eVar.f6991d)) {
                    return;
                }
            } else if (k0Var instanceof k3.k) {
                k3.k kVar = (k3.k) k0Var;
                if ("com.apple.iTunes".equals(kVar.f7003b) && "iTunSMPB".equals(kVar.f7004c) && a(kVar.f7005d)) {
                    return;
                }
            } else {
                continue;
            }
            i++;
        }
    }
}
