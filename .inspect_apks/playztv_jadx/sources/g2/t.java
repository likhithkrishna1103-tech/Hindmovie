package g2;

import aa.c1;
import aa.j0;
import android.text.TextUtils;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.m0;
import p1.n0;
import s1.b0;
import s1.u;
import s1.z;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements w2.o {
    public static final Pattern i = Pattern.compile("LOCAL:([^,]+)");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f4937j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f4939b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t3.k f4941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4942e;
    public w2.q f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4944h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f4940c = new u();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f4943g = new byte[1024];

    public t(String str, z zVar, t3.k kVar, boolean z2) {
        this.f4938a = str;
        this.f4939b = zVar;
        this.f4941d = kVar;
        this.f4942e = z2;
    }

    public final h0 b(long j5) {
        h0 h0VarQ = this.f.q(0, 3);
        p1.p pVar = new p1.p();
        pVar.f9967m = m0.p("text/vtt");
        pVar.f9960d = this.f4938a;
        pVar.f9972r = j5;
        e6.j.s(pVar, h0VarQ);
        this.f.e();
        return h0VarQ;
    }

    @Override // w2.o
    public final void c(w2.q qVar) {
        if (this.f4942e) {
            qVar = new a2.c(qVar, this.f4941d);
        }
        this.f = qVar;
        qVar.j(new w2.t(-9223372036854775807L));
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) {
        w2.l lVar = (w2.l) pVar;
        lVar.r(this.f4943g, 0, 6, false);
        byte[] bArr = this.f4943g;
        u uVar = this.f4940c;
        uVar.H(6, bArr);
        if (c4.j.a(uVar)) {
            return true;
        }
        lVar.r(this.f4943g, 6, 3, false);
        uVar.H(9, this.f4943g);
        return c4.j.a(uVar);
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        throw new IllegalStateException();
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) throws n0 {
        String strK;
        this.f.getClass();
        int length = (int) pVar.getLength();
        int i10 = this.f4944h;
        byte[] bArr = this.f4943g;
        if (i10 == bArr.length) {
            this.f4943g = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f4943g;
        int i11 = this.f4944h;
        int i12 = pVar.read(bArr2, i11, bArr2.length - i11);
        if (i12 != -1) {
            int i13 = this.f4944h + i12;
            this.f4944h = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        u uVar = new u(this.f4943g);
        c4.j.d(uVar);
        String strK2 = uVar.k(StandardCharsets.UTF_8);
        long jW = 0;
        long jC = 0;
        while (true) {
            Matcher matcher = null;
            if (TextUtils.isEmpty(strK2)) {
                while (true) {
                    String strK3 = uVar.k(StandardCharsets.UTF_8);
                    if (strK3 == null) {
                        break;
                    }
                    if (c4.j.f2504a.matcher(strK3).matches()) {
                        do {
                            strK = uVar.k(StandardCharsets.UTF_8);
                            if (strK != null) {
                            }
                        } while (!strK.isEmpty());
                    } else {
                        Matcher matcher2 = c4.i.f2500a.matcher(strK3);
                        if (matcher2.matches()) {
                            matcher = matcher2;
                            break;
                        }
                    }
                }
                if (matcher == null) {
                    b(0L);
                    return -1;
                }
                String strGroup = matcher.group(1);
                strGroup.getClass();
                long jC2 = c4.j.c(strGroup);
                int i14 = b0.f11647a;
                long jB = this.f4939b.b(b0.W((jW + jC2) - jC, 90000L, 1000000L, RoundingMode.DOWN) % 8589934592L);
                h0 h0VarB = b(jB - jC2);
                byte[] bArr3 = this.f4943g;
                int i15 = this.f4944h;
                u uVar2 = this.f4940c;
                uVar2.H(i15, bArr3);
                h0VarB.f(this.f4944h, uVar2);
                h0VarB.a(jB, 1, this.f4944h, 0, null);
                return -1;
            }
            if (strK2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher3 = i.matcher(strK2);
                if (!matcher3.find()) {
                    throw n0.a(null, "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(strK2));
                }
                Matcher matcher4 = f4937j.matcher(strK2);
                if (!matcher4.find()) {
                    throw n0.a(null, "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(strK2));
                }
                String strGroup2 = matcher3.group(1);
                strGroup2.getClass();
                jC = c4.j.c(strGroup2);
                String strGroup3 = matcher4.group(1);
                strGroup3.getClass();
                long j5 = Long.parseLong(strGroup3);
                int i16 = b0.f11647a;
                jW = b0.W(j5, 1000000L, 90000L, RoundingMode.DOWN);
            }
            strK2 = uVar.k(StandardCharsets.UTF_8);
        }
    }

    @Override // w2.o
    public final w2.o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
