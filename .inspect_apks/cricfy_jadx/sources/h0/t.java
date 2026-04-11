package h0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f5470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f5471x;

    public t(Context context) {
        this.f5469v = 0;
        this.f5470w = new ArrayList();
        this.f5471x = context;
    }

    public void a(ComponentName componentName) {
        Context context = (Context) this.f5471x;
        ArrayList arrayList = this.f5470w;
        int size = arrayList.size();
        try {
            for (Intent intentA = c.a(context, componentName); intentA != null; intentA = c.a(context, intentA.getComponent())) {
                arrayList.add(size, intentA);
            }
        } catch (PackageManager.NameNotFoundException e9) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e9);
        }
    }

    public void b() {
        ArrayList arrayList = this.f5470w;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        ((Context) this.f5471x).startActivities(intentArr, null);
    }

    public void c() {
        Iterator it = this.f5470w.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f5469v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f5470w.iterator();
            default:
                return ((HashMap) this.f5471x).keySet().iterator();
        }
    }

    public t(HashMap map) {
        this.f5469v = 1;
        this.f5471x = new HashMap();
        this.f5470w = new ArrayList();
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.trim().split("=");
                if (strArrSplit.length == 2) {
                    ((HashMap) this.f5471x).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }
}
