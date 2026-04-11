package fd;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import b2.q;
import c.d0;
import com.google.android.gms.internal.measurement.z3;
import dd.e;
import ge.i;
import i2.k;
import i2.x;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import md.o;
import rd.j;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {
    public volatile boolean A;
    public volatile boolean B;
    public id.b C;
    public volatile long D;
    public volatile boolean E;
    public volatile long F;
    public long G;
    public final j H;
    public double I;
    public final q J;
    public final md.b K;
    public final int L;
    public final pc.c M;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f4570v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final md.e f4571w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d5.a f4572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final x f4573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k f4574z;

    public d(e eVar, md.e eVar2, d5.a aVar, x xVar, k kVar) {
        i.e(eVar, "initialDownload");
        i.e(eVar2, "downloader");
        i.e(aVar, "logger");
        this.f4570v = eVar;
        this.f4571w = eVar2;
        this.f4572x = aVar;
        this.f4573y = xVar;
        this.f4574z = kVar;
        this.D = -1L;
        this.G = -1L;
        this.H = new j(new d0(3, this));
        this.J = new q(3);
        md.b bVar = new md.b();
        bVar.f8420w = 1;
        bVar.f8419v = eVar.f3676v;
        this.K = bVar;
        this.L = 1;
        this.M = new pc.c(this);
    }

    @Override // fd.b
    public final e A() {
        b().C = this.F;
        b().D = this.D;
        return b();
    }

    @Override // fd.b
    public final void Q(id.b bVar) {
        this.C = bVar;
    }

    public final long a() {
        double d10 = this.I;
        if (d10 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d10);
    }

    public final e b() {
        return (e) this.H.getValue();
    }

    public final dd.c c() {
        LinkedHashMap linkedHashMapD = s.D(this.f4570v.B);
        linkedHashMapD.put("Range", "bytes=" + this.F + "-");
        e eVar = this.f4570v;
        int i = eVar.f3676v;
        String str = eVar.f3678x;
        String str2 = eVar.f3679y;
        Uri uriT = android.support.v4.media.session.b.t(str2);
        e eVar2 = this.f4570v;
        String str3 = eVar2.I;
        long j4 = eVar2.K;
        return new dd.c(str, linkedHashMapD, str2, uriT, "GET", eVar2.M);
    }

    public final boolean d() {
        return ((this.F > 0 && this.D > 0) || this.E) && this.F >= this.D;
    }

    public final void e(md.d dVar) {
        if (this.A || this.B || !d()) {
            return;
        }
        this.D = this.F;
        b().C = this.F;
        b().D = this.D;
        this.K.f8423z = this.F;
        this.K.f8422y = this.D;
        if (this.B || this.A) {
            return;
        }
        id.b bVar = this.C;
        if (bVar != null) {
            bVar.f(b());
        }
        id.b bVar2 = this.C;
        if (bVar2 != null) {
            bVar2.b(b(), this.K, this.L);
        }
        b().P = this.G;
        b().Q = a();
        e eVarB = b();
        eVarB.getClass();
        e eVar = new e();
        z3.x(eVarB, eVar);
        id.b bVar3 = this.C;
        if (bVar3 != null) {
            bVar3.d(b(), b().P, b().Q);
        }
        b().P = -1L;
        b().Q = -1L;
        id.b bVar4 = this.C;
        if (bVar4 != null) {
            bVar4.a(eVar);
        }
    }

    @Override // fd.b
    public final boolean e0() {
        return this.A;
    }

    public final void f(BufferedInputStream bufferedInputStream, o oVar, int i) throws IOException {
        boolean z10;
        long j4 = this.F;
        byte[] bArr = new byte[i];
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        boolean z11 = false;
        int i10 = bufferedInputStream.read(bArr, 0, i);
        long jNanoTime3 = jNanoTime;
        long jNanoTime4 = jNanoTime2;
        while (!this.A && !this.B && i10 != -1) {
            oVar.q(i10, bArr);
            if (this.B || this.A) {
                z10 = z11;
                jNanoTime4 = jNanoTime4;
            } else {
                long j7 = jNanoTime3;
                this.F += (long) i10;
                b().C = this.F;
                b().D = this.D;
                this.K.f8423z = this.F;
                this.K.f8422y = this.D;
                boolean zA = android.support.v4.media.session.b.A(jNanoTime4, System.nanoTime(), 1000L);
                long j10 = jNanoTime4;
                if (zA) {
                    this.J.d(this.F - j4);
                    this.I = q.e(this.J);
                    this.G = android.support.v4.media.session.b.c(this.F, this.D, a());
                    j4 = this.F;
                }
                jNanoTime3 = j7;
                if (android.support.v4.media.session.b.A(jNanoTime3, System.nanoTime(), 2000L)) {
                    this.K.f8423z = this.F;
                    if (!this.B && !this.A) {
                        id.b bVar = this.C;
                        if (bVar != null) {
                            bVar.f(b());
                        }
                        id.b bVar2 = this.C;
                        if (bVar2 != null) {
                            bVar2.b(b(), this.K, this.L);
                        }
                        b().P = this.G;
                        b().Q = a();
                        id.b bVar3 = this.C;
                        if (bVar3 != null) {
                            bVar3.d(b(), b().P, b().Q);
                        }
                    }
                    jNanoTime3 = System.nanoTime();
                }
                jNanoTime4 = zA ? System.nanoTime() : j10;
                z10 = false;
                i10 = bufferedInputStream.read(bArr, 0, i);
            }
            z11 = z10;
        }
        switch (oVar.f8451v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) oVar.f8452w).flush();
                break;
        }
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
        throw new UnsupportedOperationException("Method not decompiled: fd.d.run():void");
    }

    @Override // fd.b
    public final void s() {
        id.b bVar = this.C;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f6442c = true;
        }
        this.A = true;
    }

    @Override // fd.b
    public final void z() {
        id.b bVar = this.C;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f6442c = true;
        }
        this.B = true;
    }
}
