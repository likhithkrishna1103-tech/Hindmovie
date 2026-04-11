package n0;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f8618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f8620e;

    public /* synthetic */ e(String str, Context context, Object obj, int i, int i10) {
        this.f8616a = i10;
        this.f8617b = str;
        this.f8618c = context;
        this.f8620e = obj;
        this.f8619d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.f8616a;
        int i10 = this.f8619d;
        Object obj = this.f8620e;
        Context context = this.f8618c;
        String str = this.f8617b;
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
