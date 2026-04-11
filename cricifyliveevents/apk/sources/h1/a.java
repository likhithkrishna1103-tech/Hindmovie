package h1;

import fe.l;
import ge.i;
import ge.j;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends j implements l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f5472w = new a(1);

    @Override // fe.l
    public final Object a(Object obj) {
        String strValueOf;
        Map.Entry entry = (Map.Entry) obj;
        i.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "[");
            int i = 0;
            for (byte b8 : (byte[]) value) {
                i++;
                if (i > 1) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) String.valueOf((int) b8));
            }
            sb.append((CharSequence) "]");
            strValueOf = sb.toString();
        } else {
            strValueOf = String.valueOf(entry.getValue());
        }
        return "  " + ((e) entry.getKey()).f5477a + " = " + strValueOf;
    }
}
