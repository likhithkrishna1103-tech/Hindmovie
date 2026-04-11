package androidx.emoji2.text;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Trace;
import g2.l1;
import g2.o0;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f892w;

    public /* synthetic */ w(int i, Object obj) {
        this.f891v = i;
        this.f892w = obj;
    }

    private final void a() {
        x xVar = (x) this.f892w;
        synchronized (xVar.f896d) {
            try {
                if (xVar.f899h == null) {
                    return;
                }
                try {
                    q0.i iVarD = xVar.d();
                    int i = iVarD.f10348e;
                    if (i == 2) {
                        synchronized (xVar.f896d) {
                        }
                    }
                    if (i != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i + ")");
                    }
                    try {
                        Method method = p0.k.f9880b;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        jb.b bVar = xVar.f895c;
                        Context context = xVar.f893a;
                        bVar.getClass();
                        q0.i[] iVarArr = {iVarD};
                        vf.g gVar = l0.g.f7609a;
                        com.bumptech.glide.c.b("TypefaceCompat.createFromFontInfo");
                        try {
                            Typeface typefaceP = l0.g.f7609a.p(context, iVarArr, 0);
                            Trace.endSection();
                            MappedByteBuffer mappedByteBufferN = w1.d.n(xVar.f893a, iVarD.f10344a);
                            if (mappedByteBufferN == null || typefaceP == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            try {
                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                b6.f fVar = new b6.f(typefaceP, com.bumptech.glide.e.n(mappedByteBufferN));
                                Trace.endSection();
                                synchronized (xVar.f896d) {
                                    try {
                                        com.bumptech.glide.c cVar = xVar.f899h;
                                        if (cVar != null) {
                                            cVar.B(fVar);
                                        }
                                    } finally {
                                    }
                                }
                                xVar.b();
                            } finally {
                                Method method2 = p0.k.f9880b;
                            }
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (xVar.f896d) {
                        try {
                            com.bumptech.glide.c cVar2 = xVar.f899h;
                            if (cVar2 != null) {
                                cVar2.A(th2);
                            }
                            xVar.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    private final void b() {
        l1 l1Var = (l1) this.f892w;
        try {
            synchronized (l1Var) {
            }
            try {
                l1Var.f4797a.b(l1Var.f4799c, l1Var.f4800d);
            } finally {
                l1Var.a(true);
            }
        } catch (g2.n e9) {
            y1.b.h("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e9);
            throw new RuntimeException(e9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112 A[LOOP:0: B:27:0x0057->B:76:0x0112, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116 A[EDGE_INSN: B:94:0x0116->B:77:0x0116 BREAK  A[LOOP:0: B:27:0x0057->B:76:0x0112], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c() {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.w.c():void");
    }

    private final void d() {
        jd.a aVar = (jd.a) this.f892w;
        synchronized (aVar.f6745a) {
            try {
                Iterator it = aVar.f6745a.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void e() {
        dd.c cVar = (dd.c) this.f892w;
        synchronized (((ArrayDeque) cVar.f3675z)) {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) cVar.f3672w).edit();
            String str = (String) cVar.f3673x;
            StringBuilder sb = new StringBuilder();
            Iterator it = ((ArrayDeque) cVar.f3675z).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append((String) cVar.f3674y);
            }
            editorEdit.putString(str, sb.toString()).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:235:0x025a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.w.run():void");
    }

    public /* synthetic */ w(o0 o0Var, l1 l1Var) {
        this.f891v = 10;
        this.f892w = l1Var;
    }

    public /* synthetic */ w(jd.a aVar, List list, md.n nVar, dd.e eVar) {
        this.f891v = 18;
        this.f892w = aVar;
    }
}
