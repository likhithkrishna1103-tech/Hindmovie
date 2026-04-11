package d7;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7.a f4092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l7.a f4093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4094d;

    public b(Context context, l7.a aVar, l7.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f4091a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f4092b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f4093c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f4094d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            b bVar = (b) ((c) obj);
            if (this.f4091a.equals(bVar.f4091a) && this.f4092b.equals(bVar.f4092b) && this.f4093c.equals(bVar.f4093c) && this.f4094d.equals(bVar.f4094d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f4091a.hashCode() ^ 1000003) * 1000003) ^ this.f4092b.hashCode()) * 1000003) ^ this.f4093c.hashCode()) * 1000003) ^ this.f4094d.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CreationContext{applicationContext=");
        sb2.append(this.f4091a);
        sb2.append(", wallClock=");
        sb2.append(this.f4092b);
        sb2.append(", monotonicClock=");
        sb2.append(this.f4093c);
        sb2.append(", backendName=");
        return l4.a.o(sb2, this.f4094d, "}");
    }
}
