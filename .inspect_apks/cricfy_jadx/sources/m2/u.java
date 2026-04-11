package m2;

import a3.i0;
import android.text.TextUtils;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ua.g0;
import ua.z0;
import v1.m0;
import v1.n0;
import y1.a0;
import y1.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements a3.p {
    public static final Pattern i = Pattern.compile("LOCAL:([^,]+)");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f8142j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f8144b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x3.n f8146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8147e;
    public a3.r f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8149h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f8145c = new y1.t();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f8148g = new byte[1024];

    public u(String str, y yVar, x3.n nVar, boolean z10) {
        this.f8143a = str;
        this.f8144b = yVar;
        this.f8146d = nVar;
        this.f8147e = z10;
    }

    public final i0 b(long j4) {
        i0 i0VarP = this.f.p(0, 3);
        v1.o oVar = new v1.o();
        oVar.f12893m = m0.p("text/vtt");
        oVar.f12886d = this.f8143a;
        oVar.f12898r = j4;
        l0.e.s(oVar, i0VarP);
        this.f.e();
        return i0VarP;
    }

    @Override // a3.p
    public final void c(a3.r rVar) {
        if (this.f8147e) {
            rVar = new com.bumptech.glide.l(rVar, this.f8146d);
        }
        this.f = rVar;
        rVar.s(new a3.u(-9223372036854775807L));
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        throw new IllegalStateException();
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) {
        a3.l lVar = (a3.l) qVar;
        lVar.v(this.f8148g, 0, 6, false);
        byte[] bArr = this.f8148g;
        y1.t tVar = this.f8145c;
        tVar.H(6, bArr);
        if (g4.j.a(tVar)) {
            return true;
        }
        lVar.v(this.f8148g, 6, 3, false);
        tVar.H(9, this.f8148g);
        return g4.j.a(tVar);
    }

    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) throws n0 {
        String strK;
        this.f.getClass();
        int length = (int) qVar.getLength();
        int i10 = this.f8149h;
        byte[] bArr = this.f8148g;
        if (i10 == bArr.length) {
            this.f8148g = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f8148g;
        int i11 = this.f8149h;
        int i12 = qVar.read(bArr2, i11, bArr2.length - i11);
        if (i12 != -1) {
            int i13 = this.f8149h + i12;
            this.f8149h = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        y1.t tVar2 = new y1.t(this.f8148g);
        g4.j.d(tVar2);
        String strK2 = tVar2.k(StandardCharsets.UTF_8);
        long jW = 0;
        long jC = 0;
        while (true) {
            Matcher matcher = null;
            if (TextUtils.isEmpty(strK2)) {
                while (true) {
                    String strK3 = tVar2.k(StandardCharsets.UTF_8);
                    if (strK3 == null) {
                        break;
                    }
                    if (g4.j.f5024a.matcher(strK3).matches()) {
                        do {
                            strK = tVar2.k(StandardCharsets.UTF_8);
                            if (strK != null) {
                            }
                        } while (!strK.isEmpty());
                    } else {
                        Matcher matcher2 = g4.i.f5020a.matcher(strK3);
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
                long jC2 = g4.j.c(strGroup);
                int i14 = a0.f14551a;
                long jB = this.f8144b.b(a0.W((jW + jC2) - jC, 90000L, 1000000L, RoundingMode.DOWN) % 8589934592L);
                i0 i0VarB = b(jB - jC2);
                byte[] bArr3 = this.f8148g;
                int i15 = this.f8149h;
                y1.t tVar3 = this.f8145c;
                tVar3.H(i15, bArr3);
                i0VarB.a(this.f8149h, tVar3);
                i0VarB.e(jB, 1, this.f8149h, 0, null);
                return -1;
            }
            if (strK2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher3 = i.matcher(strK2);
                if (!matcher3.find()) {
                    throw n0.a(null, "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(strK2));
                }
                Matcher matcher4 = f8142j.matcher(strK2);
                if (!matcher4.find()) {
                    throw n0.a(null, "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(strK2));
                }
                String strGroup2 = matcher3.group(1);
                strGroup2.getClass();
                jC = g4.j.c(strGroup2);
                String strGroup3 = matcher4.group(1);
                strGroup3.getClass();
                long j4 = Long.parseLong(strGroup3);
                int i16 = a0.f14551a;
                jW = a0.W(j4, 1000000L, 90000L, RoundingMode.DOWN);
            }
            strK2 = tVar2.k(StandardCharsets.UTF_8);
        }
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
