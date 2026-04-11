package ec;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Rating;
import android.os.Bundle;
import h4.i0;
import h4.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f4640a;

    public a(Context context) {
        be.h.e(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f4640a = bundle == null ? Bundle.EMPTY : bundle;
    }

    public Boolean a() {
        Bundle bundle = this.f4640a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    public void b(String str, Bitmap bitmap) {
        Integer num = (Integer) o.f5835w.get(str);
        if (num != null && num.intValue() != 2) {
            throw new IllegalArgumentException(e6.j.n("The ", str, " key cannot be used to put a Bitmap"));
        }
        this.f4640a.putParcelable(str, bitmap);
    }

    public void c(String str, long j5) {
        Integer num = (Integer) o.f5835w.get(str);
        if (num != null && num.intValue() != 0) {
            throw new IllegalArgumentException(e6.j.n("The ", str, " key cannot be used to put a long"));
        }
        this.f4640a.putLong(str, j5);
    }

    public void d(String str, i0 i0Var) {
        Rating rating;
        float f = i0Var.f5819v;
        int i = i0Var.f5818u;
        Integer num = (Integer) o.f5835w.get(str);
        if (num != null && num.intValue() != 3) {
            throw new IllegalArgumentException(e6.j.n("The ", str, " key cannot be used to put a Rating"));
        }
        if (i0Var.f5820w != null) {
            rating = i0Var.f5820w;
        } else {
            if (i0Var.b()) {
                switch (i) {
                    case 1:
                        i0Var.f5820w = Rating.newHeartRating(i == 1 && f == 1.0f);
                        break;
                    case 2:
                        i0Var.f5820w = Rating.newThumbRating(i == 2 && f == 1.0f);
                        break;
                    case 3:
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        i0Var.f5820w = Rating.newStarRating(i, i0Var.a());
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        if (i != 6 || !i0Var.b()) {
                            f = -1.0f;
                        }
                        i0Var.f5820w = Rating.newPercentageRating(f);
                        break;
                    default:
                        rating = null;
                        break;
                }
            } else {
                i0Var.f5820w = Rating.newUnratedRating(i);
            }
            rating = i0Var.f5820w;
        }
        this.f4640a.putParcelable(str, rating);
    }

    public void e(String str, String str2) {
        Integer num = (Integer) o.f5835w.get(str);
        if (num != null && num.intValue() != 1) {
            throw new IllegalArgumentException(e6.j.n("The ", str, " key cannot be used to put a String"));
        }
        this.f4640a.putCharSequence(str, str2);
    }

    public void f(String str, CharSequence charSequence) {
        Integer num = (Integer) o.f5835w.get(str);
        if (num != null && num.intValue() != 1) {
            throw new IllegalArgumentException(e6.j.n("The ", str, " key cannot be used to put a CharSequence"));
        }
        this.f4640a.putCharSequence(str, charSequence);
    }

    public a() {
        this.f4640a = new Bundle();
    }
}
