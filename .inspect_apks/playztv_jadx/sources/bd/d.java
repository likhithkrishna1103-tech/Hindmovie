package bd;

import a0.g;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.x;
import h4.z;
import id.h;
import id.p;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import nd.i;
import od.t;
import zc.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {
    public volatile boolean A;
    public ed.b B;
    public volatile long C;
    public volatile boolean D;
    public volatile long E;
    public long F;
    public final i G;
    public double H;
    public final g I;
    public final id.b J;
    public final int K;
    public final rc.b L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f2022u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final id.e f2023v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f2024w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x f2025x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final z f2026y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f2027z;

    public d(e eVar, id.e eVar2, h hVar, x xVar, z zVar) {
        be.h.e(eVar, "initialDownload");
        be.h.e(eVar2, "downloader");
        be.h.e(hVar, "logger");
        this.f2022u = eVar;
        this.f2023v = eVar2;
        this.f2024w = hVar;
        this.f2025x = xVar;
        this.f2026y = zVar;
        this.C = -1L;
        this.F = -1L;
        this.G = new i(new a5.e(2, this));
        this.I = new g(3);
        id.b bVar = new id.b();
        bVar.f6564v = 1;
        bVar.f6563u = eVar.f14950u;
        this.J = bVar;
        this.K = 1;
        this.L = new rc.b(5, this);
    }

    @Override // bd.b
    public final void F() {
        ed.b bVar = this.B;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f4679c = true;
        }
        this.A = true;
    }

    @Override // bd.b
    public final e H() {
        b().B = this.E;
        b().C = this.C;
        return b();
    }

    @Override // bd.b
    public final void J(ed.b bVar) {
        this.B = bVar;
    }

    public final long a() {
        double d10 = this.H;
        if (d10 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d10);
    }

    public final e b() {
        return (e) this.G.getValue();
    }

    public final zc.c c() {
        LinkedHashMap linkedHashMapK = t.K(this.f2022u.A);
        linkedHashMapK.put("Range", "bytes=" + this.E + "-");
        e eVar = this.f2022u;
        int i = eVar.f14950u;
        String str = eVar.f14952w;
        String str2 = eVar.f14953x;
        Uri uriW = android.support.v4.media.session.b.w(str2);
        e eVar2 = this.f2022u;
        String str3 = eVar2.H;
        long j5 = eVar2.J;
        return new zc.c(str, linkedHashMapK, str2, uriW, "GET", eVar2.L);
    }

    public final boolean d() {
        return ((this.E > 0 && this.C > 0) || this.D) && this.E >= this.C;
    }

    public final void e(id.d dVar) {
        if (this.f2027z || this.A || !d()) {
            return;
        }
        this.C = this.E;
        b().B = this.E;
        b().C = this.C;
        this.J.f6567y = this.E;
        this.J.f6566x = this.C;
        if (this.A || this.f2027z) {
            return;
        }
        ed.b bVar = this.B;
        if (bVar != null) {
            bVar.f(b());
        }
        ed.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.b(b(), this.J, this.K);
        }
        b().O = this.F;
        b().P = a();
        e eVarB = b();
        eVarB.getClass();
        e eVar = new e();
        z7.a.F(eVarB, eVar);
        ed.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.d(b(), b().O, b().P);
        }
        b().O = -1L;
        b().P = -1L;
        ed.b bVar4 = this.B;
        if (bVar4 != null) {
            bVar4.a(eVar);
        }
    }

    public final void f(BufferedInputStream bufferedInputStream, p pVar, int i) throws IOException {
        boolean z2;
        long j5 = this.E;
        byte[] bArr = new byte[i];
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        boolean z10 = false;
        int i10 = bufferedInputStream.read(bArr, 0, i);
        long jNanoTime3 = jNanoTime;
        long jNanoTime4 = jNanoTime2;
        while (!this.f2027z && !this.A && i10 != -1) {
            pVar.v(i10, bArr);
            if (this.A || this.f2027z) {
                z2 = z10;
                jNanoTime4 = jNanoTime4;
            } else {
                long j8 = jNanoTime3;
                this.E += (long) i10;
                b().B = this.E;
                b().C = this.C;
                this.J.f6567y = this.E;
                this.J.f6566x = this.C;
                boolean zB = android.support.v4.media.session.b.B(jNanoTime4, System.nanoTime(), 1000L);
                long j10 = jNanoTime4;
                if (zB) {
                    this.I.d(this.E - j5);
                    this.H = g.e(this.I);
                    this.F = android.support.v4.media.session.b.d(this.E, this.C, a());
                    j5 = this.E;
                }
                jNanoTime3 = j8;
                if (android.support.v4.media.session.b.B(jNanoTime3, System.nanoTime(), 2000L)) {
                    this.J.f6567y = this.E;
                    if (!this.A && !this.f2027z) {
                        ed.b bVar = this.B;
                        if (bVar != null) {
                            bVar.f(b());
                        }
                        ed.b bVar2 = this.B;
                        if (bVar2 != null) {
                            bVar2.b(b(), this.J, this.K);
                        }
                        b().O = this.F;
                        b().P = a();
                        ed.b bVar3 = this.B;
                        if (bVar3 != null) {
                            bVar3.d(b(), b().O, b().P);
                        }
                    }
                    jNanoTime3 = System.nanoTime();
                }
                jNanoTime4 = zB ? System.nanoTime() : j10;
                z2 = false;
                i10 = bufferedInputStream.read(bArr, 0, i);
            }
            z10 = z2;
        }
        switch (pVar.f6597u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) pVar.f6598v).flush();
                break;
        }
    }

    @Override // bd.b
    public final boolean g0() {
        return this.f2027z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|220|(2:210|3)|(1:118)(7:7|(3:222|9|(1:13))|19|(1:21)(1:26)|27|229|(6:82|(2:91|92)|(2:99|100)|101|(2:110|111)|112)(18:33|(3:39|40|41)(1:38)|42|(1:44)(1:47)|48|(3:50|(1:52)|53)|54|237|55|(1:81)(6:59|235|60|(4:64|(1:66)|72|(1:74))|75|76)|228|119|(2:142|(1:145))(2:125|(6:129|(1:131)|136|(1:138)|139|(1:141)))|(2:224|147)|(2:226|151)|(2:155|219)|158|195))|113|228|119|(6:121|142|(1:145)|(0)|(0)|(0))(0)|158|195|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0246, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0247, code lost:
    
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0288 A[Catch: all -> 0x0242, Exception -> 0x0246, TryCatch #0 {all -> 0x0242, blocks: (B:119:0x0204, B:121:0x020a, B:123:0x020e, B:125:0x0212, B:127:0x0232, B:129:0x0236, B:131:0x023a, B:136:0x0249, B:138:0x024d, B:139:0x0258, B:141:0x026e, B:142:0x0288, B:145:0x0290, B:159:0x02bb, B:161:0x02bf, B:163:0x02c3, B:168:0x02ee, B:169:0x02f1, B:176:0x0308, B:177:0x030a, B:179:0x0333, B:181:0x0337, B:183:0x0347, B:172:0x02fc, B:173:0x02ff), top: B:210:0x000b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ad A[Catch: Exception -> 0x02b1, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x02b1, blocks: (B:155:0x02ad, B:193:0x0368), top: B:220:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02bf A[Catch: all -> 0x0242, TryCatch #0 {all -> 0x0242, blocks: (B:119:0x0204, B:121:0x020a, B:123:0x020e, B:125:0x0212, B:127:0x0232, B:129:0x0236, B:131:0x023a, B:136:0x0249, B:138:0x024d, B:139:0x0258, B:141:0x026e, B:142:0x0288, B:145:0x0290, B:159:0x02bb, B:161:0x02bf, B:163:0x02c3, B:168:0x02ee, B:169:0x02f1, B:176:0x0308, B:177:0x030a, B:179:0x0333, B:181:0x0337, B:183:0x0347, B:172:0x02fc, B:173:0x02ff), top: B:210:0x000b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0308 A[Catch: all -> 0x0242, TryCatch #0 {all -> 0x0242, blocks: (B:119:0x0204, B:121:0x020a, B:123:0x020e, B:125:0x0212, B:127:0x0232, B:129:0x0236, B:131:0x023a, B:136:0x0249, B:138:0x024d, B:139:0x0258, B:141:0x026e, B:142:0x0288, B:145:0x0290, B:159:0x02bb, B:161:0x02bf, B:163:0x02c3, B:168:0x02ee, B:169:0x02f1, B:176:0x0308, B:177:0x030a, B:179:0x0333, B:181:0x0337, B:183:0x0347, B:172:0x02fc, B:173:0x02ff), top: B:210:0x000b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0333 A[Catch: all -> 0x0242, TryCatch #0 {all -> 0x0242, blocks: (B:119:0x0204, B:121:0x020a, B:123:0x020e, B:125:0x0212, B:127:0x0232, B:129:0x0236, B:131:0x023a, B:136:0x0249, B:138:0x024d, B:139:0x0258, B:141:0x026e, B:142:0x0288, B:145:0x0290, B:159:0x02bb, B:161:0x02bf, B:163:0x02c3, B:168:0x02ee, B:169:0x02f1, B:176:0x0308, B:177:0x030a, B:179:0x0333, B:181:0x0337, B:183:0x0347, B:172:0x02fc, B:173:0x02ff), top: B:210:0x000b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0347 A[Catch: all -> 0x0242, TRY_LEAVE, TryCatch #0 {all -> 0x0242, blocks: (B:119:0x0204, B:121:0x020a, B:123:0x020e, B:125:0x0212, B:127:0x0232, B:129:0x0236, B:131:0x023a, B:136:0x0249, B:138:0x024d, B:139:0x0258, B:141:0x026e, B:142:0x0288, B:145:0x0290, B:159:0x02bb, B:161:0x02bf, B:163:0x02c3, B:168:0x02ee, B:169:0x02f1, B:176:0x0308, B:177:0x030a, B:179:0x0333, B:181:0x0337, B:183:0x0347, B:172:0x02fc, B:173:0x02ff), top: B:210:0x000b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0368 A[Catch: Exception -> 0x02b1, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x02b1, blocks: (B:155:0x02ad, B:193:0x0368), top: B:220:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0388 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0350 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0370 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x035b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x037b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v28 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.d.run():void");
    }

    @Override // bd.b
    public final void x() {
        ed.b bVar = this.B;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f4679c = true;
        }
        this.f2027z = true;
    }
}
