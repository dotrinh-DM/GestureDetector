# GestureDetector

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            LogI("Double Tap at: (" + x + "," + y + ")");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            LogI("onLongPress at: (" + x + "," + y + ")");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            LogI("onScroll 11: (" + e1.getX() + ", " + e1.getY() + ")");
            LogI("onScroll 22: (" + e2.getX() + ", " + e2.getY() + ")");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            LogI("onFling 11: (" + e1.getX() + ", " + e1.getY() + ")");
            LogI("onFling 22: (" + e2.getX() + ", " + e2.getY() + ")");
            return super.onFling(e1, e2, velocityX, velocityY);
        }
