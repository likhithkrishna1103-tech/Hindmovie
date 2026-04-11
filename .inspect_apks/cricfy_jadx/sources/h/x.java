package h;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends androidx.fragment.app.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5408c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f5409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5410e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a0 a0Var, androidx.emoji2.text.v vVar) {
        super(a0Var);
        this.f5409d = a0Var;
        this.f5410e = vVar;
    }

    @Override // androidx.fragment.app.h
    public final IntentFilter e() {
        switch (this.f5408c) {
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
        boolean z10;
        long j4;
        switch (this.f5408c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return t.a((PowerManager) this.f5410e) ? 2 : 1;
            default:
                androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) this.f5410e;
                j0 j0Var = (j0) vVar.f890y;
                LocationManager locationManager = (LocationManager) vVar.f889x;
                if (j0Var.f5362b <= System.currentTimeMillis()) {
                    Context context = (Context) vVar.f888w;
                    Location lastKnownLocation = null;
                    if (i0.c.b(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e9) {
                            Log.d("TwilightManager", "Failed to get last known location", e9);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (i0.c.b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (i0.f5356e == null) {
                            i0.f5356e = new i0();
                        }
                        i0 i0Var = i0.f5356e;
                        i0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                        i0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                        z10 = i0Var.f5358b == 1;
                        long j7 = i0Var.f5360d;
                        long j10 = i0Var.f5359c;
                        i0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + 86400000);
                        long j11 = i0Var.f5360d;
                        if (j7 == -1 || j10 == -1) {
                            j4 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis > j10) {
                                j7 = j11;
                            } else if (jCurrentTimeMillis > j7) {
                                j7 = j10;
                            }
                            j4 = j7 + 60000;
                        }
                        j0Var.f5361a = z10;
                        j0Var.f5362b = j4;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z10 = true;
                        }
                    }
                    break;
                } else {
                    z10 = j0Var.f5361a;
                }
                return z10 ? 2 : 1;
        }
    }

    @Override // androidx.fragment.app.h
    public final void m() throws IllegalAccessException {
        switch (this.f5408c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5409d.m(true, true);
                break;
            default:
                this.f5409d.m(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a0 a0Var, Context context) {
        super(a0Var);
        this.f5409d = a0Var;
        this.f5410e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
