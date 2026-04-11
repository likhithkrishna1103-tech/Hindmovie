package d7;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map f3498c;

    public n(Map map) {
        this.f3497b = Collections.unmodifiableMap(map);
    }

    @Override // d7.k
    public final Map a() {
        if (this.f3498c == null) {
            synchronized (this) {
                try {
                    if (this.f3498c == null) {
                        this.f3498c = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f3498c;
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f3497b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = ((m) list.get(i)).f3496a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put((String) entry.getKey(), string);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f3497b.equals(((n) obj).f3497b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3497b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f3497b + '}';
    }
}
