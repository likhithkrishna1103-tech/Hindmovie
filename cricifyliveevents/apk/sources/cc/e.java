package cc;

import ac.g;
import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ac.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2137a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonWriter f2138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f2140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ac.d f2141e;
    public final boolean f;

    public e(Writer writer, HashMap map, HashMap map2, a aVar, boolean z10) {
        this.f2138b = new JsonWriter(writer);
        this.f2139c = map;
        this.f2140d = map2;
        this.f2141e = aVar;
        this.f = z10;
    }

    @Override // ac.e
    public final ac.e a(ac.c cVar, boolean z10) throws IOException {
        String str = cVar.f409a;
        j();
        JsonWriter jsonWriter = this.f2138b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(z10);
        return this;
    }

    @Override // ac.e
    public final ac.e b(ac.c cVar, double d10) throws IOException {
        String str = cVar.f409a;
        j();
        JsonWriter jsonWriter = this.f2138b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(d10);
        return this;
    }

    @Override // ac.e
    public final ac.e c(ac.c cVar, int i) throws IOException {
        String str = cVar.f409a;
        j();
        JsonWriter jsonWriter = this.f2138b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(i);
        return this;
    }

    @Override // ac.e
    public final ac.e d(ac.c cVar, long j4) throws IOException {
        String str = cVar.f409a;
        j();
        JsonWriter jsonWriter = this.f2138b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(j4);
        return this;
    }

    @Override // ac.g
    public final g e(String str) throws IOException {
        j();
        this.f2138b.value(str);
        return this;
    }

    @Override // ac.g
    public final g f(boolean z10) throws IOException {
        j();
        this.f2138b.value(z10);
        return this;
    }

    @Override // ac.e
    public final ac.e g(ac.c cVar, Object obj) throws IOException {
        i(obj, cVar.f409a);
        return this;
    }

    public final e h(Object obj) {
        JsonWriter jsonWriter = this.f2138b;
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
                    } catch (ClassCastException e9) {
                        throw new ac.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e9);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            ac.d dVar = (ac.d) this.f2139c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            ac.f fVar = (ac.f) this.f2140d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.f2141e.a(obj, this);
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
                long j4 = jArr[i];
                j();
                jsonWriter.value(j4);
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
        boolean z10 = this.f;
        JsonWriter jsonWriter = this.f2138b;
        if (z10) {
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
        if (!this.f2137a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
