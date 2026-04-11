package o2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f9216b = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9217a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(v1.m mVar) {
        this(0L);
        Uri uri = mVar.f13157a;
        Map map = Collections.EMPTY_MAP;
    }

    public u(long j5) {
        this.f9217a = j5;
    }
}
