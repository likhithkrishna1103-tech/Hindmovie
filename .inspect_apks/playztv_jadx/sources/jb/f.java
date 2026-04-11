package jb;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements gb.e {
    public static final Charset f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f6927g = new gb.c("key", l4.a.r(l4.a.q(e.class, new a(1))));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gb.c f6928h = new gb.c("value", l4.a.r(l4.a.q(e.class, new a(2))));
    public static final ib.a i = new ib.a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f6929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f6931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gb.d f6932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f6933e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, gb.d dVar) {
        this.f6929a = byteArrayOutputStream;
        this.f6930b = map;
        this.f6931c = map2;
        this.f6932d = dVar;
    }

    public static int j(gb.c cVar) {
        e eVar = (e) ((Annotation) cVar.f5366b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f6923a;
        }
        throw new gb.b("Field has no @Protobuf config");
    }

    @Override // gb.e
    public final gb.e a(gb.c cVar, double d10) throws IOException {
        e(cVar, d10, true);
        return this;
    }

    @Override // gb.e
    public final gb.e b(gb.c cVar, int i10) {
        f(cVar, i10, true);
        return this;
    }

    @Override // gb.e
    public final gb.e c(gb.c cVar, boolean z2) {
        f(cVar, z2 ? 1 : 0, true);
        return this;
    }

    @Override // gb.e
    public final gb.e d(gb.c cVar, long j5) throws IOException {
        if (j5 == 0) {
            return this;
        }
        e eVar = (e) ((Annotation) cVar.f5366b.get(e.class));
        if (eVar == null) {
            throw new gb.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f6923a << 3);
        l(j5);
        return this;
    }

    public final void e(gb.c cVar, double d10, boolean z2) throws IOException {
        if (z2 && d10 == 0.0d) {
            return;
        }
        k((j(cVar) << 3) | 1);
        this.f6929a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d10).array());
    }

    public final void f(gb.c cVar, int i10, boolean z2) {
        if (z2 && i10 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f5366b.get(e.class));
        if (eVar == null) {
            throw new gb.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f6923a << 3);
        k(i10);
    }

    @Override // gb.e
    public final gb.e g(gb.c cVar, Object obj) {
        h(cVar, obj, true);
        return this;
    }

    public final void h(gb.c cVar, Object obj, boolean z2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z2 && charSequence.length() == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            k(bytes.length);
            this.f6929a.write(bytes);
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
            e(cVar, ((Double) obj).doubleValue(), z2);
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z2 && fFloatValue == 0.0f) {
                return;
            }
            k((j(cVar) << 3) | 5);
            this.f6929a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z2 && jLongValue == 0) {
                return;
            }
            e eVar = (e) ((Annotation) cVar.f5366b.get(e.class));
            if (eVar == null) {
                throw new gb.b("Field has no @Protobuf config");
            }
            k(((a) eVar).f6923a << 3);
            l(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            f(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z2);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z2 && bArr.length == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            k(bArr.length);
            this.f6929a.write(bArr);
            return;
        }
        gb.d dVar = (gb.d) this.f6930b.get(obj.getClass());
        if (dVar != null) {
            i(dVar, cVar, obj, z2);
            return;
        }
        gb.f fVar = (gb.f) this.f6931c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.f6933e;
            hVar.f6935a = false;
            hVar.f6937c = cVar;
            hVar.f6936b = z2;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            f(cVar, ((c) obj).a(), true);
        } else if (obj instanceof Enum) {
            f(cVar, ((Enum) obj).ordinal(), true);
        } else {
            i(this.f6932d, cVar, obj, z2);
        }
    }

    public final void i(gb.d dVar, gb.c cVar, Object obj, boolean z2) throws IOException {
        b bVar = new b();
        bVar.f6924u = 0L;
        try {
            OutputStream outputStream = this.f6929a;
            this.f6929a = bVar;
            try {
                dVar.a(obj, this);
                this.f6929a = outputStream;
                long j5 = bVar.f6924u;
                bVar.close();
                if (z2 && j5 == 0) {
                    return;
                }
                k((j(cVar) << 3) | 2);
                l(j5);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f6929a = outputStream;
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
            this.f6929a.write((i10 & ModuleDescriptor.MODULE_VERSION) | 128);
            i10 >>>= 7;
        }
        this.f6929a.write(i10 & ModuleDescriptor.MODULE_VERSION);
    }

    public final void l(long j5) throws IOException {
        while (((-128) & j5) != 0) {
            this.f6929a.write((((int) j5) & ModuleDescriptor.MODULE_VERSION) | 128);
            j5 >>>= 7;
        }
        this.f6929a.write(((int) j5) & ModuleDescriptor.MODULE_VERSION);
    }
}
