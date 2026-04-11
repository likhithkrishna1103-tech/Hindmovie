package ib;

import android.util.Base64;
import android.util.JsonWriter;
import gb.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements gb.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6482a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonWriter f6483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f6484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f6485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gb.d f6486e;
    public final boolean f;

    public e(Writer writer, HashMap map, HashMap map2, a aVar, boolean z2) {
        this.f6483b = new JsonWriter(writer);
        this.f6484c = map;
        this.f6485d = map2;
        this.f6486e = aVar;
        this.f = z2;
    }

    @Override // gb.e
    public final gb.e a(gb.c cVar, double d10) throws IOException {
        String str = cVar.f5365a;
        j();
        JsonWriter jsonWriter = this.f6483b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(d10);
        return this;
    }

    @Override // gb.e
    public final gb.e b(gb.c cVar, int i) throws IOException {
        String str = cVar.f5365a;
        j();
        JsonWriter jsonWriter = this.f6483b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(i);
        return this;
    }

    @Override // gb.e
    public final gb.e c(gb.c cVar, boolean z2) throws IOException {
        String str = cVar.f5365a;
        j();
        JsonWriter jsonWriter = this.f6483b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(z2);
        return this;
    }

    @Override // gb.e
    public final gb.e d(gb.c cVar, long j5) throws IOException {
        String str = cVar.f5365a;
        j();
        JsonWriter jsonWriter = this.f6483b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(j5);
        return this;
    }

    @Override // gb.g
    public final g e(String str) throws IOException {
        j();
        this.f6483b.value(str);
        return this;
    }

    @Override // gb.g
    public final g f(boolean z2) throws IOException {
        j();
        this.f6483b.value(z2);
        return this;
    }

    @Override // gb.e
    public final gb.e g(gb.c cVar, Object obj) throws IOException {
        i(obj, cVar.f5365a);
        return this;
    }

    public final e h(Object obj) {
        JsonWriter jsonWriter = this.f6483b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i(entry.getValue(), (String) key);
                    } catch (ClassCastException e10) {
                        throw new gb.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            gb.d dVar = (gb.d) this.f6484c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            gb.f fVar = (gb.f) this.f6485d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.f6486e.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            if (obj instanceof f) {
                int iA = ((f) obj).a();
                j();
                jsonWriter.value(iA);
                return this;
            }
            String strName = ((Enum) obj).name();
            j();
            jsonWriter.value(strName);
            return this;
        }
        if (obj instanceof byte[]) {
            j();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                jsonWriter.value(r7[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j5 = jArr[i];
                j();
                jsonWriter.value(j5);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                jsonWriter.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                jsonWriter.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i < length5) {
                h(numberArr[i]);
                i++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i < length6) {
                h(objArr[i]);
                i++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e i(Object obj, String str) throws IOException {
        boolean z2 = this.f;
        JsonWriter jsonWriter = this.f6483b;
        if (z2) {
            if (obj == null) {
                return this;
            }
            j();
            jsonWriter.name(str);
            h(obj);
            return this;
        }
        j();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        h(obj);
        return this;
    }

    public final void j() {
        if (!this.f6482a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
