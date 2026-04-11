package q0;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10335e;

    public /* synthetic */ e(String str, Context context, Object obj, int i, int i10) {
        this.f10331a = i10;
        this.f10332b = str;
        this.f10333c = context;
        this.f10335e = obj;
        this.f10334d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.f10331a;
        int i10 = this.f10334d;
        Object obj = this.f10335e;
        Context context = this.f10333c;
        String str = this.f10332b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object[] objArr = {(d) obj};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                return h.b(str, context, Collections.unmodifiableList(arrayList), i10);
            default:
                try {
                    return h.b(str, context, (List) obj, i10);
                } catch (Throwable unused) {
                    return new g(-3);
                }
        }
    }
}
