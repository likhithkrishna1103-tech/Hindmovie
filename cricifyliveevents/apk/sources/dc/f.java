package dc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ac.e {
    public static final Charset f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f3657g = new ac.c("key", l0.e.o(l0.e.n(e.class, new a(1))));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ac.c f3658h = new ac.c("value", l0.e.o(l0.e.n(e.class, new a(2))));
    public static final cc.a i = new cc.a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f3659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ac.d f3662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f3663e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, ac.d dVar) {
        this.f3659a = byteArrayOutputStream;
        this.f3660b = map;
        this.f3661c = map2;
        this.f3662d = dVar;
    }

    public static int j(ac.c cVar) {
        e eVar = (e) ((Annotation) cVar.f410b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f3653a;
        }
        throw new ac.b("Field has no @Protobuf config");
    }

    @Override // ac.e
    public final ac.e a(ac.c cVar, boolean z10) throws IOException {
        f(cVar, z10 ? 1 : 0, true);
        return this;
    }

    @Override // ac.e
    public final ac.e b(ac.c cVar, double d10) throws IOException {
        e(cVar, d10, true);
        return this;
    }

    @Override // ac.e
    public final ac.e c(ac.c cVar, int i10) throws IOException {
        f(cVar, i10, true);
        return this;
    }

    @Override // ac.e
    public final ac.e d(ac.c cVar, long j4) throws IOException {
        if (j4 == 0) {
            return this;
        }
        e eVar = (e) ((Annotation) cVar.f410b.get(e.class));
        if (eVar == null) {
            throw new ac.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f3653a << 3);
        l(j4);
        return this;
    }

    public final void e(ac.c cVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return;
        }
        k((j(cVar) << 3) | 1);
        this.f3659a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d10).array());
    }

    public final void f(ac.c cVar, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f410b.get(e.class));
        if (eVar == null) {
            throw new ac.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f3653a << 3);
        k(i10);
    }

    @Override // ac.e
    public final ac.e g(ac.c cVar, Object obj) throws IOException {
        h(cVar, obj, true);
        return this;
    }

    public final void h(ac.c cVar, Object obj, boolean z10) throws IOException {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            k(bytes.length);
            this.f3659a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                h(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                i(i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            e(cVar, ((Double) obj).doubleValue(), z10);
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z10 && fFloatValue == 0.0f) {
                return;
            }
            k((j(cVar) << 3) | 5);
            this.f3659a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z10 && jLongValue == 0) {
                return;
            }
            e eVar = (e) ((Annotation) cVar.f410b.get(e.class));
            if (eVar == null) {
                throw new ac.b("Field has no @Protobuf config");
            }
            k(((a) eVar).f3653a << 3);
            l(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            f(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z10);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z10 && bArr.length == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            k(bArr.length);
            this.f3659a.write(bArr);
            return;
        }
        ac.d dVar = (ac.d) this.f3660b.get(obj.getClass());
        if (dVar != null) {
            i(dVar, cVar, obj, z10);
            return;
        }
        ac.f fVar = (ac.f) this.f3661c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.f3663e;
            hVar.f3665a = false;
            hVar.f3667c = cVar;
            hVar.f3666b = z10;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            f(cVar, ((c) obj).a(), true);
        } else if (obj instanceof Enum) {
            f(cVar, ((Enum) obj).ordinal(), true);
        } else {
            i(this.f3662d, cVar, obj, z10);
        }
    }

    public final void i(ac.d dVar, ac.c cVar, Object obj, boolean z10) throws IOException {
        b bVar = new b();
        bVar.f3654v = 0L;
        try {
            OutputStream outputStream = this.f3659a;
            this.f3659a = bVar;
            try {
                dVar.a(obj, this);
                this.f3659a = outputStream;
                long j4 = bVar.f3654v;
                bVar.close();
                if (z10 && j4 == 0) {
                    return;
                }
                k((j(cVar) << 3) | 2);
                l(j4);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f3659a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void k(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f3659a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f3659a.write(i10 & 127);
    }

    public final void l(long j4) throws IOException {
        while (((-128) & j4) != 0) {
            this.f3659a.write((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        this.f3659a.write(((int) j4) & 127);
    }
}
