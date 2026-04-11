package h;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends androidx.fragment.app.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5568c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b0 f5569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5570e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, a7.b bVar) {
        super(b0Var);
        this.f5569d = b0Var;
        this.f5570e = bVar;
    }

    @Override // androidx.fragment.app.h
    public final IntentFilter e() {
        switch (this.f5568c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // androidx.fragment.app.h
    public final int f() {
        Location location;
        boolean z2;
        long j5;
        switch (this.f5568c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return t.a((PowerManager) this.f5570e) ? 2 : 1;
            default:
                a7.b bVar = (a7.b) this.f5570e;
                k0 k0Var = (k0) bVar.f620x;
                LocationManager locationManager = (LocationManager) bVar.f619w;
                if (k0Var.f5513b <= System.currentTimeMillis()) {
                    Context context = (Context) bVar.f618v;
                    Location lastKnownLocation = null;
                    if (f0.c.b(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (f0.c.b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e11) {
                            Log.d("TwilightManager", "Failed to get last known location", e11);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (j0.f5508d == null) {
                            j0.f5508d = new j0();
                        }
                        j0 j0Var = j0.f5508d;
                        j0Var.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        j0Var.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z2 = j0Var.f5511c == 1;
                        long j8 = j0Var.f5510b;
                        long j10 = j0Var.f5509a;
                        j0Var.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j11 = j0Var.f5510b;
                        if (j8 == -1 || j10 == -1) {
                            j5 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis > j10) {
                                j8 = j11;
                            } else if (jCurrentTimeMillis > j8) {
                                j8 = j10;
                            }
                            j5 = j8 + 60000;
                        }
                        k0Var.f5512a = z2;
                        k0Var.f5513b = j5;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z2 = true;
                        }
                    }
                    break;
                } else {
                    z2 = k0Var.f5512a;
                }
                return z2 ? 2 : 1;
        }
    }

    @Override // androidx.fragment.app.h
    public final void l() throws IllegalAccessException {
        switch (this.f5568c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5569d.n(true, true);
                break;
            default:
                this.f5569d.n(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Context context) {
        super(b0Var);
        this.f5569d = b0Var;
        this.f5570e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
