package i6;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map f6411c;

    public l(Map map) {
        this.f6410b = Collections.unmodifiableMap(map);
    }

    @Override // i6.i
    public final Map a() {
        if (this.f6411c == null) {
            synchronized (this) {
                try {
                    if (this.f6411c == null) {
                        this.f6411c = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f6411c;
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f6410b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = ((k) list.get(i)).f6409a;
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                    if (i != list.size() - 1) {
                        sb2.append(',');
                    }
                }
            }
            String string = sb2.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f6410b.equals(((l) obj).f6410b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6410b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f6410b + '}';
    }
}
