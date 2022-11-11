package nextstep.subway.station.ui;

import nextstep.subway.station.application.StationCommandService;
import nextstep.subway.station.application.StationQueryService;
import nextstep.subway.station.dto.StationRequest;
import nextstep.subway.station.dto.StationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    private final StationCommandService stationCommandService;
    private final StationQueryService stationQueryService;

    public StationController(StationCommandService stationCommandService, StationQueryService stationQueryService) {
        this.stationCommandService = stationCommandService;
        this.stationQueryService = stationQueryService;
    }

    @PostMapping
    public ResponseEntity<StationResponse> createStation(@RequestBody StationRequest stationRequest) {
        StationResponse station = stationCommandService.saveStation(stationRequest);
        return ResponseEntity.created(URI.create("/stations/" + station.getId())).body(station);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StationResponse>> showStations() {
        return ResponseEntity.ok().body(stationQueryService.findAllStations());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationCommandService.deleteStationById(id);
        return ResponseEntity.noContent().build();
    }
}
