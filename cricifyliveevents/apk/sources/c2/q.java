package c2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f2040c = new q(Collections.EMPTY_MAP);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2042b;

    public q(Map map) {
        this.f2042b = Collections.unmodifiableMap(map);
    }

    public static boolean b(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final q a(g gVar) {
        byte[] bytes;
        Map map = this.f2042b;
        HashMap map2 = new HashMap(map);
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList((ArrayList) gVar.f2010b));
        for (int i = 0; i < listUnmodifiableList.size(); i++) {
            map2.remove(listUnmodifiableList.get(i));
        }
        HashMap map3 = new HashMap((HashMap) gVar.f2009a);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        for (Map.Entry entry2 : Collections.unmodifiableMap(map3).entrySet()) {
            String str = (String) entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2 instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) value2).longValue()).array();
            } else if (value2 instanceof String) {
                bytes = ((String) value2).getBytes(StandardCharsets.UTF_8);
            } else {
                if (!(value2 instanceof byte[])) {
                    throw new IllegalArgumentException();
                }
                bytes = (byte[]) value2;
            }
            map2.put(str, bytes);
        }
        return b(map, map2) ? this : new q(map2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return b(this.f2042b, ((q) obj).f2042b);
    }

    public final int hashCode() {
        if (this.f2041a == 0) {
            int iHashCode = 0;
            for (Map.Entry entry : this.f2042b.entrySet()) {
                iHashCode += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f2041a = iHashCode;
        }
        return this.f2041a;
    }
}
